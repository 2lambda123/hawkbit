/**
 * Copyright (c) 2021 Bosch.IO GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.ui.management.targettag.targettype;

import com.vaadin.ui.Grid;
import com.vaadin.ui.themes.ValoTheme;
import org.eclipse.hawkbit.ui.common.builder.GridComponentBuilder;
import org.eclipse.hawkbit.ui.common.data.proxies.ProxyType;
import org.eclipse.hawkbit.ui.common.grid.AbstractGrid;
import org.eclipse.hawkbit.ui.common.grid.selection.RangeSelectionModel;
import org.eclipse.hawkbit.ui.utils.SPUIDefinitions;
import org.eclipse.hawkbit.ui.utils.UIComponentIdProvider;
import org.eclipse.hawkbit.ui.utils.VaadinMessageSource;

/**
 * Distribution Set Source Type grid which is shown on the Target Type
 * Create/Update popup layout.
 */
public class DsTypeSourceGrid extends Grid<ProxyType> {
    private static final long serialVersionUID = 1L;

    private final VaadinMessageSource i18n;

    /**
     * Constructor for DsTypeSourceGrid
     *
     * @param i18n
     *            VaadinMessageSource
     */
    public DsTypeSourceGrid(final VaadinMessageSource i18n) {
        this.i18n = i18n;

        init();
    }

    private void init() {
        setSizeFull();
        setHeightUndefined();
        addStyleName(ValoTheme.TABLE_NO_HORIZONTAL_LINES);
        addStyleName(ValoTheme.TABLE_NO_STRIPES);
        addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
        addStyleName(ValoTheme.TABLE_SMALL);
        // used to deactivate cell text selection by user
        addStyleName(AbstractGrid.MULTI_SELECT_STYLE);

        setId(SPUIDefinitions.TWIN_TABLE_SOURCE_ID);
        setSelectionModel(new RangeSelectionModel<>(i18n));

        addColumns();
    }

    private void addColumns() {
        GridComponentBuilder.addColumn(this, ProxyType::getName).setId(UIComponentIdProvider.DIST_TYPE_TABLE_SOURCE_ID)
                .setCaption(i18n.getMessage("header.dt.twintable.available"))
                .setDescriptionGenerator(ProxyType::getDescription);
    }
}
