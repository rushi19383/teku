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

package tech.pegasys.teku.infrastructure.ssz.impl;

import tech.pegasys.teku.infrastructure.ssz.InvalidValueSchemaException;
import tech.pegasys.teku.infrastructure.ssz.SszData;
import tech.pegasys.teku.infrastructure.ssz.schema.SszCollectionSchema;
import tech.pegasys.teku.infrastructure.ssz.schema.SszSchema;

public abstract class AbstractSszMutableCollection<
        SszElementT extends SszData, SszMutableElementT extends SszElementT>
    extends AbstractSszMutableComposite<SszElementT, SszMutableElementT> {

  private final SszSchema<SszElementT> elementSchema;

  protected AbstractSszMutableCollection(
      final AbstractSszComposite<SszElementT> backingImmutableData) {
    super(backingImmutableData);
    elementSchema = getSchema().getElementSchema();
  }

  private SszSchema<SszElementT> getElementSchema() {
    return elementSchema;
  }

  @Override
  @SuppressWarnings("unchecked")
  public SszCollectionSchema<SszElementT, ?> getSchema() {
    return (SszCollectionSchema<SszElementT, ?>) super.getSchema();
  }

  @Override
  protected void validateChildSchema(final int index, final SszElementT value) {
    if (!value.getSchema().equals(getElementSchema())) {
      throw new InvalidValueSchemaException(
          "Expected element to have schema "
              + getSchema().getChildSchema(index)
              + ", but value has schema "
              + value.getSchema());
    }
  }
}
