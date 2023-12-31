/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.mgmt.json.model.rollout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MgmtRolloutSuccessAction {

    private SuccessAction action = SuccessAction.NEXTGROUP;
    private String expression = null;

    /**
     * 
     */
    public MgmtRolloutSuccessAction() {
        // needed for json creator
    }

    public MgmtRolloutSuccessAction(final SuccessAction action, final String expression) {
        this.action = action;
        this.expression = expression;
    }

    /**
     * @return the action
     */
    public SuccessAction getAction() {
        return action;
    }

    /**
     * @param action
     *            the action to set
     */
    public void setAction(final SuccessAction action) {
        this.action = action;
    }

    /**
     * @return the expession
     */
    public String getExpression() {
        return expression;
    }

    /**
     * @param expession
     *            the expession to set
     */
    public void setExpression(final String expession) {
        this.expression = expession;
    }

    public enum SuccessAction {
        NEXTGROUP
    }
}
