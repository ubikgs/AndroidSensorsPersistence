package com.ubikgs.androidsensors.persistence.repositories.imu;

import com.ubikgs.androidsensors.persistence.DaggerTestBedComponent;
import com.ubikgs.androidsensors.persistence.repositories.SensorRecordRepositoryIntegrationTest;
import com.ubikgs.androidsensors.records.imu.GravityRecord;

import org.junit.Before;

import javax.inject.Inject;

import static com.ubikgs.androidsensors.persistence.testutils.TestEntityProvider.createGravityRecord;

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
public class GravityRecordRepositoryIntegrationTest extends SensorRecordRepositoryIntegrationTest<GravityRecord> {

    @Inject GravityRecordRepository gravityRecordRepository;

    @Before
    public void setUp() throws Exception {
        DaggerTestBedComponent.create().inject(this);
        sensorRecordRepository = gravityRecordRepository;
    }

    @Override
    protected GravityRecord createSensorRecord() {
        return createGravityRecord();
    }
}