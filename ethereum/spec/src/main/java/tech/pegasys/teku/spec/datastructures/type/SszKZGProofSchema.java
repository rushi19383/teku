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

package tech.pegasys.teku.spec.datastructures.type;

import tech.pegasys.teku.infrastructure.json.types.DeserializableTypeDefinition;
import tech.pegasys.teku.infrastructure.ssz.schema.SszPrimitiveSchemas;
import tech.pegasys.teku.infrastructure.ssz.schema.collections.impl.SszByteVectorSchemaImpl;
import tech.pegasys.teku.infrastructure.ssz.schema.json.SszPrimitiveTypeDefinitions;
import tech.pegasys.teku.infrastructure.ssz.tree.TreeNode;

public class SszKZGProofSchema extends SszByteVectorSchemaImpl<SszKZGProof> {
  private static final int KZG_PROOF_SIZE = 48;

  public static final SszKZGProofSchema INSTANCE = new SszKZGProofSchema();

  private SszKZGProofSchema() {
    super(SszPrimitiveSchemas.BYTE_SCHEMA, KZG_PROOF_SIZE);
  }

  @Override
  protected DeserializableTypeDefinition<SszKZGProof> createTypeDefinition() {
    return SszPrimitiveTypeDefinitions.sszSerializedType(this, "Bytes48 hexadecimal");
  }

  @Override
  public SszKZGProof createFromBackingNode(final TreeNode node) {
    return new SszKZGProof(node);
  }
}
