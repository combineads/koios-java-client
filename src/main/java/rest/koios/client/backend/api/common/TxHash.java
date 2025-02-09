package rest.koios.client.backend.api.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Transaction Hash
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxHash {

    /**
     * Transaction Hash
     */
    private String txHash;

    /**
     * Epoch number of the block
     */
    private Integer epochNo;

    /**
     * Block Height
     */
    private Integer blockHeight;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;
}
