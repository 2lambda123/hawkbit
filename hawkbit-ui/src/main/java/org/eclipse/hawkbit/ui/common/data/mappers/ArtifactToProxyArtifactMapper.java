/**
 * Copyright (c) 2020 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.common.data.mappers;

import org.eclipse.hawkbit.repository.model.Artifact;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyArtifact;
import org.eclipse.hawkbit.ui.utils.SPDateTimeUtil;

/**
 * Maps {@link Artifact} entities, fetched from backend, to the
 * {@link ProxyArtifact} entities.
 */
public class ArtifactToProxyArtifactMapper
        implements IdentifiableEntityToProxyIdentifiableEntityMapper<ProxyArtifact, Artifact> {

    @Override
    public ProxyArtifact map(final Artifact artifact) {
        final ProxyArtifact proxyArtifact = new ProxyArtifact();

        proxyArtifact.setId(artifact.getId());
        proxyArtifact.setFilename(artifact.getFilename());
        proxyArtifact.setMd5Hash(artifact.getMd5Hash());
        proxyArtifact.setSha1Hash(artifact.getSha1Hash());
        proxyArtifact.setSha256Hash(artifact.getSha256Hash());
        proxyArtifact.setSize(artifact.getSize());
        proxyArtifact.setModifiedDate(SPDateTimeUtil.getFormattedDate(artifact.getLastModifiedAt()));

        return proxyArtifact;
    }
}
