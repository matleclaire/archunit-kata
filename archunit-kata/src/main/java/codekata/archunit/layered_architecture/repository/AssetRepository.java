package codekata.archunit.layered_architecture.repository;

import codekata.archunit.layered_architecture.model.entity.Asset;

import java.util.Optional;

public class AssetRepository {

    public Optional<Asset> findById(long assetId) {
        // Query database and return asset
        return Optional.empty();
    }
}
