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

package tech.pegasys.teku;

import java.util.Optional;
import tech.pegasys.teku.services.beaconchain.BeaconChainServiceFacade;
import tech.pegasys.teku.services.chainstorage.StorageServiceFacade;

/**
 * CAUTION: this API is unstable and primarily intended for debugging and testing purposes this API
 * might be changed in any version in backward incompatible way
 */
public interface BeaconNodeFacade extends NodeFacade {

  /** Shortcut method to find {@link BeaconChainServiceFacade} service if any */
  default Optional<BeaconChainServiceFacade> getBeaconChainService() {
    return getServiceController().getServices().stream()
        .filter(service -> service instanceof BeaconChainServiceFacade)
        .map(service -> (BeaconChainServiceFacade) service)
        .findFirst();
  }

  /** Shortcut method to find {@link StorageServiceFacade} service if any */
  default Optional<StorageServiceFacade> getStorageService() {
    return getServiceController().getServices().stream()
        .filter(service -> service instanceof StorageServiceFacade)
        .map(service -> (StorageServiceFacade) service)
        .findFirst();
  }
}
