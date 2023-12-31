/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.filtermanagement.client;

import java.io.Serializable;

/**
 * A suggestion which contains the start and the end character position of the
 * suggested token of the suggestion of the token and the actual suggestion.
 */
public class SuggestTokenDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int start;
    private int end;
    private String suggestion;

    /**
     * Default constructor.
     */
    public SuggestTokenDto() {
        // necessary for java serialization with GWT.
    }

    /**
     * Constructor.
     * 
     * @param start
     *            the character position of the start of the token
     * @param end
     *            the character position of the end of the token
     * @param suggestion
     *            the token suggestion
     */
    public SuggestTokenDto(final int start, final int end, final String suggestion) {
        this.start = start;
        this.end = end;
        this.suggestion = suggestion;
    }

    /**
     * @return Character start position
     */
    public int getStart() {
        return start;
    }

    /**
     * @return Character end position
     */
    public int getEnd() {
        return end;
    }

    /**
     * @return Suggestion text
     */
    public String getSuggestion() {
        return suggestion;
    }

    /**
     * Sets the character start position
     *
     * @param start
     *          Index
     */
    public void setStart(final int start) {
        this.start = start;
    }

    /**
     * Sets the character start position
     *
     * @param end
     *          Index
     */
    public void setEnd(final int end) {
        this.end = end;
    }

    /**
     * Sets the suggestion text
     *
     * @param suggestion
     *          Suggestion
     */
    public void setSuggestion(final String suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "SuggestTokenDto [start=" + start + ", end=" + end + ", suggestion=" + suggestion + "]";
    }
}
