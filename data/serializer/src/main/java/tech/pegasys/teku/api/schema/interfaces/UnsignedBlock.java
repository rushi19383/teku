/*
 * Copyright Consensys Software Inc., 2025
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.api.schema.interfaces;

import io.swagger.v3.oas.annotations.media.Schema;
import tech.pegasys.teku.api.schema.altair.BeaconBlockAltair;
import tech.pegasys.teku.api.schema.bellatrix.BeaconBlockBellatrix;
import tech.pegasys.teku.api.schema.capella.BeaconBlockCapella;
import tech.pegasys.teku.api.schema.deneb.BeaconBlockDeneb;
import tech.pegasys.teku.api.schema.electra.BeaconBlockElectra;
import tech.pegasys.teku.api.schema.phase0.BeaconBlockPhase0;

@Schema(
    oneOf = {
      BeaconBlockPhase0.class,
      BeaconBlockAltair.class,
      BeaconBlockBellatrix.class,
      BeaconBlockCapella.class,
      BeaconBlockDeneb.class,
      BeaconBlockElectra.class
    })
public interface UnsignedBlock {}
