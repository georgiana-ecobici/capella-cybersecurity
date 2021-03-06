/*******************************************************************************
 * Copyright (c) 2019, 2020 THALES GLOBAL SERVICES.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;

// displays the max level of all threats to the asset
public class ThreatLevelColumn extends AbstractCybersecurityColumn {
  public ThreatLevelColumn() {
    id = getClass().getCanonicalName();
    label = Messages.PrimaryAssetColumns_Label_MaxThreatLevel;
    name = Messages.PrimaryAssetColumns_Name_MaxThreatLevel;
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    return CybersecurityQueries.getThreatsOf(((PrimaryAsset) rowObject)).map(t -> t.getLevel()).reduce(Math::max)
        .orElse(0);
  }
}