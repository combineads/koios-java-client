package rest.koios.client.backend.api.account;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.account.model.*;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountServicePreprodIntegrationTest {

    private AccountService accountService;

    @BeforeAll
    public void setup() {
        accountService = BackendFactory.getKoiosPreprodService().getAccountService();
    }

    @Test
    void getAccountListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<StakeAddress>> stakeAddressesResult = accountService.getAccountList(options);
        Assertions.assertTrue(stakeAddressesResult.isSuccessful());
        Assertions.assertNotNull(stakeAddressesResult.getValue());
        log.info(stakeAddressesResult.getValue().toString());
        assertEquals(10, stakeAddressesResult.getValue().size());
    }

    @Test
    void getAccountInformationTest() throws ApiException {
        String address = "stake_test1uzcmuv8c6pj3ld9mrvml3jhxl7j4hvh4xskr6ce37dvpfdqjmdvh8";
        Result<List<AccountInfo>> accountInformationResult = accountService.getAccountInformation(List.of(address), Options.EMPTY);
        Assertions.assertTrue(accountInformationResult.isSuccessful());
        Assertions.assertNotNull(accountInformationResult.getValue());
        log.info(accountInformationResult.getValue().toString());
    }

    @Test
    void getAccountInformationBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountInformation(List.of(address), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountInformationCachedTest() throws ApiException {
        String address1 = "stake_test1urq4rcynzj4uxqc74c852zky7wa6epgmn9r6k3j3gv7502q8jks0l";
        String address2 = "stake_test1ur4t5nhceyn2amfuj7z74uxmmj8jf9fmgd2egqw8c98ve3cp2g4wx";
        Result<List<AccountInfo>> accountInformationResult = accountService.getCachedAccountInformation(List.of(address1, address2), Options.EMPTY);
        Assertions.assertTrue(accountInformationResult.isSuccessful());
        Assertions.assertNotNull(accountInformationResult.getValue());
        log.info(accountInformationResult.getValue().toString());
    }

    @Test
    void getAccountInformationCachedBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getCachedAccountInformation(List.of(address), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountRewardsTest() throws ApiException {
        int epochNo = 33;
        String stakeAddress = "stake_test1uzcmuv8c6pj3ld9mrvml3jhxl7j4hvh4xskr6ce37dvpfdqjmdvh8";
        Result<List<AccountRewards>> accountRewardsResult = accountService.getAccountRewards(List.of(stakeAddress), epochNo, Options.EMPTY);
        Assertions.assertTrue(accountRewardsResult.isSuccessful());
        Assertions.assertNotNull(accountRewardsResult.getValue());
        assertFalse(accountRewardsResult.getValue().isEmpty());
        assertFalse(accountRewardsResult.getValue().get(0).getRewards().isEmpty());
        assertEquals(epochNo, accountRewardsResult.getValue().get(0).getRewards().get(0).getEarnedEpoch());
        log.info(accountRewardsResult.getValue().toString());
    }

    @Test
    void getAccountRewardsBadRequestBadAddressTest() {
        String stakeAddress = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountRewards(List.of(stakeAddress), 180, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountUpdatesTest() throws ApiException {
        String stakeAddress = "stake_test1uzcmuv8c6pj3ld9mrvml3jhxl7j4hvh4xskr6ce37dvpfdqjmdvh8";
        Result<List<AccountUpdates>> accountUpdatesResult = accountService.getAccountUpdates(List.of(stakeAddress), Options.EMPTY);
        Assertions.assertTrue(accountUpdatesResult.isSuccessful());
        Assertions.assertNotNull(accountUpdatesResult.getValue());
        log.info(accountUpdatesResult.getValue().toString());
    }

    @Test
    void getAccountUpdatesBadRequestTest() {
        String stakeAddress = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountUpdates(List.of(stakeAddress), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountAddressesTest() throws ApiException {
        String address = "stake_test1uzcmuv8c6pj3ld9mrvml3jhxl7j4hvh4xskr6ce37dvpfdqjmdvh8";
        Result<List<AccountAddress>> accountAddressesResult = accountService.getAccountAddresses(List.of(address), Options.EMPTY);
        Assertions.assertTrue(accountAddressesResult.isSuccessful());
        Assertions.assertNotNull(accountAddressesResult.getValue());
        log.info(accountAddressesResult.getValue().toString());
    }

    @Test
    void getAccountAddressesBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountAddresses(List.of(address), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountAssetsTest() throws ApiException {
        String address = "stake_test1uzcmuv8c6pj3ld9mrvml3jhxl7j4hvh4xskr6ce37dvpfdqjmdvh8";
        Result<List<AccountAssets>> accountAssetsResult = accountService.getAccountAssets(List.of(address), null, Options.EMPTY);
        Assertions.assertTrue(accountAssetsResult.isSuccessful());
        Assertions.assertNotNull(accountAssetsResult.getValue());
        log.info(accountAssetsResult.getValue().toString());
    }

    @Test
    void getAccountAssetsBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountAssets(List.of(address), null, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountHistoryTest() throws ApiException {
        String address = "stake_test1uzcmuv8c6pj3ld9mrvml3jhxl7j4hvh4xskr6ce37dvpfdqjmdvh8";
        Result<List<AccountHistory>> accountHistoryResult = accountService.getAccountHistory(List.of(address),null, Options.EMPTY);
        Assertions.assertTrue(accountHistoryResult.isSuccessful());
        Assertions.assertNotNull(accountHistoryResult.getValue());
        log.info(accountHistoryResult.getValue().toString());
    }

    @Test
    void getAccountHistoryBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountHistory(List.of(address), null, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }
}
