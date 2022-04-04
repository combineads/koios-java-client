package rest.koios.client.backend.api.pool.api;

import rest.koios.client.backend.api.pool.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Pool API
 */
public interface PoolApi {

    @GET("pool_list")
    Call<List<Pool>> getPoolList(@QueryMap Map<String, String> paramsMap);

    @POST("pool_info")
    Call<List<PoolInfo>> getPoolInformation(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    @GET("pool_delegators")
    Call<List<PoolDelegator>> getPoolDelegatorsListByEpoch(@Query("_pool_bech32") String poolBech32, @Query("_epoch_no") Long epochNo, @QueryMap Map<String, String> paramsMap);

    @GET("pool_delegators")
    Call<List<PoolDelegator>> getPoolDelegatorsList(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> paramsMap);

    @GET("pool_blocks")
    Call<List<PoolBlock>> getPoolBlocksByEpoch(@Query("_pool_bech32") String poolBech32, @Query("_epoch_no") Long epochNo, @QueryMap Map<String, String> paramsMap);

    @GET("pool_blocks")
    Call<List<PoolBlock>> getPoolBlocks(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> paramsMap);

    @GET("pool_history")
    Call<List<PoolHistory>> getPoolHistoryByEpoch(@Query("_pool_bech32") String poolBech32, @Query("_epoch_no") Long epochNo, @QueryMap Map<String, String> optionsToParamMap);

    @GET("pool_history")
    Call<List<PoolHistory>> getPoolHistory(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> optionsToParamMap);

    @GET("pool_updates")
    Call<List<PoolUpdate>> getPoolUpdatesByPoolBech32(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> paramsMap);

    @GET("pool_updates")
    Call<List<PoolUpdate>> getPoolUpdates(@QueryMap Map<String, String> paramsMap);

    @GET("pool_relays")
    Call<List<PoolRelay>> getPoolRelays(@QueryMap Map<String, String> paramsMap);

    @POST("pool_metadata")
    Call<List<PoolMetadata>> getPoolMetadata(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);
}
