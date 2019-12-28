package com.cers.warning.wall.WallApi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WarningRepository extends JpaRepository<WarningEntity, Long>, JpaSpecificationExecutor<WarningEntity> {

}
