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

package tech.pegasys.teku.spec.datastructures.builder;

import org.apache.tuweni.units.bigints.UInt256;
import tech.pegasys.teku.bls.BLSPublicKey;
import tech.pegasys.teku.infrastructure.ssz.SszList;
import tech.pegasys.teku.spec.datastructures.execution.ExecutionPayloadHeader;
import tech.pegasys.teku.spec.datastructures.execution.versions.electra.ExecutionRequests;
import tech.pegasys.teku.spec.datastructures.type.SszKZGCommitment;

public interface BuilderBidBuilder {

  BuilderBidBuilder header(ExecutionPayloadHeader header);

  BuilderBidBuilder blobKzgCommitments(SszList<SszKZGCommitment> blobKzgCommitments);

  BuilderBidBuilder executionRequests(ExecutionRequests executionRequests);

  BuilderBidBuilder value(UInt256 value);

  BuilderBidBuilder publicKey(BLSPublicKey publicKey);

  BuilderBid build();
}
