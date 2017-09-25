package com.ubikgs.androidsensors.persistence.repositories.imu;

import com.ubikgs.androidsensors.persistence.daos.imu.RotationVectorRecordEntityDao;
import com.ubikgs.androidsensors.persistence.entities.imu.RotationVectorRecordEntity;
import com.ubikgs.androidsensors.persistence.repositories.SensorRecordRepositoryTest;
import com.ubikgs.androidsensors.records.imu.RotationVectorRecord;

import org.junit.Before;
import org.mockito.Mock;

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
public class RotationVectorRecordRepositoryTest extends SensorRecordRepositoryTest<RotationVectorRecord, RotationVectorRecordEntity> {

    @Mock RotationVectorRecordEntityDao rotationVectorRecordEntityDao;

    @Before
    public void setUp() throws Exception {
        sensorRecordEntityDao = rotationVectorRecordEntityDao;
        sensorRecordRepository = new RotationVectorRecordRepository(rotationVectorRecordEntityDao);
    }

    @Override
    protected RotationVectorRecord createSensorRecord() {
        return new RotationVectorRecord();
    }

    @Override
    protected RotationVectorRecordEntity createSensorRecordEntity() {
        return new RotationVectorRecordEntity();
    }

}