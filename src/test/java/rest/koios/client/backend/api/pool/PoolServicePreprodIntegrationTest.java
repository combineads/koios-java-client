package rest.koios.client.backend.api.pool;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.pool.model.*;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PoolServicePreprodIntegrationTest {

    private PoolService poolService;

    @BeforeAll
    public void setup() {
        poolService = BackendFactory.getKoiosPreprodService().getPoolService();
    }

    @Test
    void getPoolListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<Pool>> poolListResult = poolService.getPoolList(options);
        Assertions.assertTrue(poolListResult.isSuccessful());
        Assertions.assertNotNull(poolListResult.getValue());
        log.info(poolListResult.getValue().toString());
        assertEquals(10, poolListResult.getValue().size());
    }

    @Test
    void getPoolInformationTest() throws ApiException {
        String poolId = "pool124jq2jje25v9gtrjxk8qm34ujrcsa3msy4tm04nl2262j5scclv";
        Result<List<PoolInfo>> poolInfosResult = poolService.getPoolInformation(List.of(poolId), Options.EMPTY);
        Assertions.assertTrue(poolInfosResult.isSuccessful());
        Assertions.assertNotNull(poolInfosResult.getValue());
        log.info(poolInfosResult.getValue().toString());
    }

    @Test
    void getPoolInformationBadRequestTest() {
        String poolId = "asdsa";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolInformation(List.of(poolId), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolStakeSnapshotTest() throws ApiException {
        String poolBech32 = "pool124jq2jje25v9gtrjxk8qm34ujrcsa3msy4tm04nl2262j5scclv";
        Result<List<PoolStakeSnapshot>> poolInfosResult = poolService.getPoolStakeSnapshot(poolBech32, Options.EMPTY);
        Assertions.assertTrue(poolInfosResult.isSuccessful());
        Assertions.assertNotNull(poolInfosResult.getValue());
        log.info(poolInfosResult.getValue().toString());
    }

    @Test
    void getPoolStakeSnapshotBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolStakeSnapshot(poolBech32, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolDelegatorsHistoryTest() throws ApiException {
        String poolBech32 = "pool124jq2jje25v9gtrjxk8qm34ujrcsa3msy4tm04nl2262j5scclv";
        Result<List<PoolDelegatorHistory>> poolDelegatorsResult = poolService.getPoolDelegatorsHistory(poolBech32, 180, Options.EMPTY);
        Assertions.assertTrue(poolDelegatorsResult.isSuccessful());
        Assertions.assertNotNull(poolDelegatorsResult.getValue());
        log.info(poolDelegatorsResult.getValue().toString());
    }

    @Test
    void getPoolDelegatorsListBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolDelegatorsHistory(poolBech32, 180, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolBlocksTest() throws ApiException {
        String poolBech32 = "pool124jq2jje25v9gtrjxk8qm34ujrcsa3msy4tm04nl2262j5scclv";
        Result<List<PoolBlock>> poolBlocksResult = poolService.getPoolBlocksByEpoch(poolBech32, 180, Options.EMPTY);
        Assertions.assertTrue(poolBlocksResult.isSuccessful());
        Assertions.assertNotNull(poolBlocksResult.getValue());
        log.info(poolBlocksResult.getValue().toString());
    }

    @Test
    void getPoolBlocksLimitTest() throws ApiException {
        String poolBech32 = "pool124jq2jje25v9gtrjxk8qm34ujrcsa3msy4tm04nl2262j5scclv";
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PoolBlock>> poolBlocksResult = poolService.getPoolBlocks(poolBech32, options);
        Assertions.assertTrue(poolBlocksResult.isSuccessful());
        Assertions.assertNotNull(poolBlocksResult.getValue());
        log.info(poolBlocksResult.getValue().toString());
        assertEquals(10, poolBlocksResult.getValue().size());
    }

    @Test
    void getPoolBlocksBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolBlocksByEpoch(poolBech32, 180, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolHistoryByEpochTest() throws ApiException {
        String poolBech32 = "pool124jq2jje25v9gtrjxk8qm34ujrcsa3msy4tm04nl2262j5scclv";
        Integer epochNo = 32;
        Result<PoolHistory> poolHistoryResult = poolService.getPoolHistoryByEpoch(poolBech32, epochNo,Options.EMPTY);
        Assertions.assertTrue(poolHistoryResult.isSuccessful());
        Assertions.assertNotNull(poolHistoryResult.getValue());
        log.info(poolHistoryResult.getValue().toString());
    }

    @Test
    void getPoolHistoryLimitTest() throws ApiException {
        String poolBech32 = "pool124jq2jje25v9gtrjxk8qm34ujrcsa3msy4tm04nl2262j5scclv";
        Options options = Options.builder().option(Limit.of(4)).build();
        Result<List<PoolHistory>> poolHistoryResult = poolService.getPoolHistory(poolBech32, options);
        Assertions.assertTrue(poolHistoryResult.isSuccessful());
        Assertions.assertNotNull(poolHistoryResult.getValue());
        log.info(poolHistoryResult.getValue().toString());
        assertEquals(4, poolHistoryResult.getValue().size());
    }

    @Test
    void getPoolHistoryBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolHistoryByEpoch(poolBech32, 180, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolUpdatesTest() throws ApiException {
        String poolBech32 = "pool124jq2jje25v9gtrjxk8qm34ujrcsa3msy4tm04nl2262j5scclv";
        Result<List<PoolUpdate>> poolUpdatesResult = poolService.getPoolUpdatesByPoolBech32(poolBech32, Options.EMPTY);
        Assertions.assertTrue(poolUpdatesResult.isSuccessful());
        Assertions.assertNotNull(poolUpdatesResult.getValue());
        log.info(poolUpdatesResult.getValue().toString());
    }

    @Test
    void getPoolUpdatesLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PoolUpdate>> poolUpdatesResult = poolService.getPoolUpdates(options);
        Assertions.assertTrue(poolUpdatesResult.isSuccessful());
        Assertions.assertNotNull(poolUpdatesResult.getValue());
        log.info(poolUpdatesResult.getValue().toString());
        assertEquals(10, poolUpdatesResult.getValue().size());
    }

    @Test
    void getPoolUpdatesBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolUpdatesByPoolBech32(poolBech32, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolRelaysLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PoolRelay>> poolRelaysResult = poolService.getPoolRelays(options);
        Assertions.assertTrue(poolRelaysResult.isSuccessful());
        Assertions.assertNotNull(poolRelaysResult.getValue());
        log.info(poolRelaysResult.getValue().toString());
        assertEquals(10, poolRelaysResult.getValue().size());
    }

    @Test
    void getPoolMetadataLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PoolMetadata>> poolMetadataResult = poolService.getPoolMetadata(options);
        Assertions.assertTrue(poolMetadataResult.isSuccessful());
        Assertions.assertNotNull(poolMetadataResult.getValue());
        log.info(poolMetadataResult.getValue().toString());
        assertEquals(10, poolMetadataResult.getValue().size());
    }
}
