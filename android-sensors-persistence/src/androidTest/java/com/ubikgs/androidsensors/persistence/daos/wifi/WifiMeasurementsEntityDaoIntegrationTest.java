package com.ubikgs.androidsensors.persistence.daos.wifi;

import com.ubikgs.androidsensors.persistence.DaggerTestBedComponent;
import com.ubikgs.androidsensors.persistence.daos.RecordEntityDaoIntegrationTest;
import com.ubikgs.androidsensors.persistence.entities.wifi.WifiMeasurementsEntity;

import org.junit.Before;

import javax.inject.Inject;

import static com.ubikgs.androidsensors.persistence.testutils.TestEntityProvider.createWifiMeasurementsEntity;

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
public class WifiMeasurementsEntityDaoIntegrationTest extends RecordEntityDaoIntegrationTest<WifiMeasurementsEntity> {

    @Inject WifiMeasurementsEntityDao wifiMeasurementsEntityDao;

    @Before
    public void setUp() throws Exception {
        DaggerTestBedComponent.create().inject(this);

        recordEntityDao = wifiMeasurementsEntityDao;

        WifiMeasurementsEntity entity1 = createWifiMeasurementsEntity();
        entity1.setForeignKey(registerForeignKeyUsage(0));
        registerTestEntity(entity1);

        WifiMeasurementsEntity entity2 = createWifiMeasurementsEntity();
        entity2.setForeignKey(registerForeignKeyUsage(1));
        registerTestEntity(entity2);
    }

}