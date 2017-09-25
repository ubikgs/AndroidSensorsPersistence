package com.ubikgs.androidsensors.persistence.repositories.gps;

import com.ubikgs.androidsensors.persistence.daos.gps.RawGPSMeasurementsRecordEntityDao;
import com.ubikgs.androidsensors.persistence.entities.gps.RawGPSMeasurementsRecordEntity;
import com.ubikgs.androidsensors.persistence.repositories.AbstractSensorRecordRepository;
import com.ubikgs.androidsensors.records.gps.RawGPSMeasurementsRecord;

import javax.inject.Inject;

/**
 * Copyright 2017 Alberto González Pérez
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * <p>http://www.apache.org/licenses/LICENSE-2.0</p>
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class RawGPSMeasurementsRecordRepository extends AbstractSensorRecordRepository<RawGPSMeasurementsRecord, RawGPSMeasurementsRecordEntity> {

    @Inject
    public RawGPSMeasurementsRecordRepository(RawGPSMeasurementsRecordEntityDao sensorRecordEntityDao) {
        super(sensorRecordEntityDao);
    }

    @Override
    protected RawGPSMeasurementsRecordEntity createFrom(RawGPSMeasurementsRecord sensorRecord) {
        return new RawGPSMeasurementsRecordEntity(sensorRecord);
    }

    @Override
    protected RawGPSMeasurementsRecord transformIn(RawGPSMeasurementsRecordEntity entity) {
        return entity.toSensorRecord();
    }
}