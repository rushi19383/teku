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

package tech.pegasys.teku.api.schema;

import java.util.Optional;
import tech.pegasys.teku.api.schema.bellatrix.ExecutionPayloadBellatrix;
import tech.pegasys.teku.api.schema.capella.ExecutionPayloadCapella;
import tech.pegasys.teku.api.schema.deneb.ExecutionPayloadDeneb;

public interface ExecutionPayload {

  default Optional<ExecutionPayloadBellatrix> toVersionBellatrix() {
    return Optional.empty();
  }

  default Optional<ExecutionPayloadCapella> toVersionCapella() {
    return Optional.empty();
  }

  default Optional<ExecutionPayloadDeneb> toVersionDeneb() {
    return Optional.empty();
  }
}
