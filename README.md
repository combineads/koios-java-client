<div align="center">
    <hr/>
        <h1 align="center" style="border-bottom: none">Koios Java Client</h1>

[![Build](https://github.com/cardano-community/koios-java-client/actions/workflows/maven.yml/badge.svg)](https://github.com/cardano-community/koios-java-client/actions/workflows/.github/workflows/maven.yml)
[![codeQL](https://github.com/cardano-community/koios-java-client/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/cardano-community/koios-java-client/actions/workflows/.github/workflows/codeql-analysis.yml)
[![Coverage](.github/badges/jacoco.svg)](https://github.com/cardano-community/koios-java-client/actions/workflows/.github/workflows/maven.yml)
[![License](https://img.shields.io:/github/license/cardano-community/koios-java-client?color=blue&label=license)](https://opensource.org/licenses/Apache-2.0)
<hr/>
</div>

## What is Koios?
**Koios** Java Client Library is based on [Koios](https://www.koios.rest/) Elastic Query Layer for [Cardano Node](https://github.com/input-output-hk/cardano-node/) by [Cardano Community Guild Operators](https://github.com/cardano-community). <br>
**Koios** is best described as a Decentralized and Elastic RESTful query layer for exploring data on Cardano blockchain to consume within applications/wallets/explorers/etc. <br>
Resource and maintenance requirements for Cardano blockchain components (e.g. cardano-node, cardano-db-sync) are ever-growing. Along with that, every builder needs to identify how to query complex information from the chain.

## Overview
**Koios Java Client** is a Java REST Client library which allows interacting with **Koios** Server Instances using Java Objects.

## Features
- Synchronous REST messaging using java objects
- Structured Java Objects logging
- Pagination (Limit and Offset) Supported
- Horizontal Filtering Supported
- Sorting Supported
- Rate Control
- Supported REST Services:
    - [x] Network
        - Chain Tip
        - Genesis Info
        - Historical Tokenomic Statistics
    - [x] Epoch
        - Epoch Information
        - Epoch's Protocol Parameters
    - [x] Block
        - Block List
        - Block Information
        - Block Transactions
    - [x] Transactions
        - Transaction Information
        - Transaction UTxOs
        - Transaction Metadata
        - Transaction Metadata Labels
        - Transaction Submission
        - Transaction Status (Block Confirmations)
    - [x] Address
        - Address Information
        - Address Transactions
        - Transactions from Payment Credentials
        - Address Assets
    - [x] Account
        - Account List
        - Account Information
        - Account Rewards
        - Account Updates (History)
        - Account Addresses
        - Account Assets
        - Account History
    - [x] Asset
        - Asset List
        - Asset Address List
        - Asset Information
        - Asset History
        - Asset Policy Information
        - Asset Summary
        - Asset Transaction History
    - [x] Pool
        - Pool List
        - Pool Information
        - Pool Delegators List
        - Pool Blocks
        - Pool Updates (History)
        - Pool Relays
        - Pool Metadata
    - [x] Script
        - Script List
        - Script Redeemers

## Use as a library in a Java Project

### Add dependency

- For Maven, add the following dependency to project's pom.xml
```
<dependency>
    <groupId>io.github.cardano-community</groupId>
    <artifactId>koios-java-client</artifactId>
    <version>1.2</version>
</dependency>
```

- For Gradle, add the following dependency to build.gradle
```
compile group: 'io.github.cardano-community', name: 'koios-java-client', version: '1.2'
```

### Get Koios Backend Service
- Mainnet
```
BackendService backendService = BackendFactory.getKoiosMainnetService();
```

- Testnet
```
BackendService backendService = BackendFactory.getKoiosTestnetService();
```

- Guildnet
```
BackendService backendService = BackendFactory.getKoiosGuildService();
```

### Get Koios Backend Services
```
NetworkService networkService = backendService.getNetworkService();
EpochService epochService = backendService.getEpochService();
BlockService blockService = backendService.getBlockService();
TransactionsService transactionsService = backendService.getTransactionsService();
AddressService addressService = backendService.getAddressService();
AccountService accountService = backendService.getAccountService();
AssetService assetService = backendService.getAssetService();
PoolService poolService = backendService.getPoolService();
ScriptService scriptService = backendService.getScriptService();
```

## Clone & Build with Maven
```
git clone https://github.com/cardano-community/koios-java-client.git
cd koios-java-client
mvn clean install
```

## Used by
* [ISR - Israeli Cardano Community](https://www.cardano-israel.com/)
* [MusicBox - CNFT Project](https://www.musicboxnft.com/)

<hr/>
<div align="center">

</div>

<p align="center">
<a href="CONTRIBUTING.md">:triangular_ruler: Contributing</a>
  |
<a href="SPONSORS.md">:gift_heart: Sponsors</a>
</p>
