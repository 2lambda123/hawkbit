/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.repository.model;

import org.eclipse.hawkbit.repository.Identifiable;

import java.io.Serializable;


/**
 * Use to display software modules for the selected distribution.
 *
 */
public class AssignedSoftwareModule implements Serializable, Identifiable<Long> {

    private static final long serialVersionUID = 1L;

    private final SoftwareModule softwareModule;

    private final boolean assigned;

    /**
     * Constructor.
     *
     * @param softwareModule
     *            entity.
     * @param assigned
     *            as true if the software module is assigned and false if not
     *            assigned.
     */
    public AssignedSoftwareModule(final SoftwareModule softwareModule, final boolean assigned) {
        this.softwareModule = softwareModule;
        this.assigned = assigned;
    }

    /**
     * @return {@link SoftwareModule}
     */
    public SoftwareModule getSoftwareModule() {
        return softwareModule;
    }

    /**
     * @return <code>true</code> if assigned
     */
    public boolean isAssigned() {
        return assigned;
    }

    @Override
    public String toString() {
        return "AssignedSoftwareModule [softwareModule=" + softwareModule + ", assigned=" + assigned + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (assigned ? 1231 : 1237);
        result = prime * result + ((softwareModule == null) ? 0 : softwareModule.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssignedSoftwareModule other = (AssignedSoftwareModule) obj;
        if (assigned != other.assigned) {
            return false;
        }
        if (softwareModule == null) {
            if (other.softwareModule != null) {
                return false;
            }
        } else if (!softwareModule.equals(other.softwareModule)) {
            return false;
        }
        return true;
    }

    @Override
    public Long getId() {
        return softwareModule.getId();
    }

}
