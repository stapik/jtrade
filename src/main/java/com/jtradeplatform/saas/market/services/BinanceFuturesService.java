package com.jtradeplatform.saas.market.services;

import com.binance.client.model.market.ExchangeInformation;
import com.jtradeplatform.saas.configs.BinanceApiConfig;
import com.binance.client.*;
import org.springframework.stereotype.Service;

@Service
public final class BinanceFuturesService {

    private final BinanceApiConfig binanceApiConfig;

    BinanceFuturesService(BinanceApiConfig binanceApiConfig) {
        this.binanceApiConfig = binanceApiConfig;
    }

    public ExchangeInformation getExchangeInfo() {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(
                binanceApiConfig.getApiKey(),
                binanceApiConfig.getSecretKey(),
                options
        );
        return syncRequestClient.getExchangeInformation();
    }
}
