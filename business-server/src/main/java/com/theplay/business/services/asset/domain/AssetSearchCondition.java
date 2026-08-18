package com.theplay.business.services.asset.domain;


public record AssetSearchCondition(String name, AssetCategory category, AssetStatus status, Long workspaceId) {
}
