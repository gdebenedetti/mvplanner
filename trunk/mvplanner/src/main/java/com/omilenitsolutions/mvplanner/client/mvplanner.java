package com.omilenitsolutions.mvplanner.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class mvplanner implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Make a command that we will execute from all leaves.
		Command cmd = new Command() {
			public void execute() {
				Window.alert("You selected a menu item!");
			}
		};

		// Make some sub-menus that we will cascade from the top menu.
		MenuBar fooMenu = new MenuBar(true);
		fooMenu.addItem("the", cmd);
		fooMenu.addItem("foo", cmd);
		fooMenu.addItem("menu", cmd);

		MenuBar barMenu = new MenuBar(true);
		barMenu.addItem("the", cmd);
		barMenu.addItem("bar", cmd);
		barMenu.addItem("menu", cmd);

		MenuBar bazMenu = new MenuBar(true);
		bazMenu.addItem("the", cmd);
		bazMenu.addItem("baz", cmd);
		bazMenu.addItem("menu", cmd);

		// Make a new menu bar, adding a few cascading menus to it.
		MenuBar menu = new MenuBar();
		menu.addItem("foo", fooMenu);
		menu.addItem("bar", barMenu);
		menu.addItem("baz", bazMenu);
		
		// Create a tab panel
		TabPanel tabPanel = new TabPanel();

		// Set the width to 400 pixels
		tabPanel.setWidth("400px");

		// Add a home tab
		HTML homeText = new HTML("Click one the tabs to see more content.");
		tabPanel.add(homeText, "Home");

		// Add a tab with an image
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(new Image("http://code.google.com/webtoolkit/logo-185x175.png"));
		tabPanel.add(vPanel, "GWT Logo");

		// Add a third tab
		HTML moreInfo = new HTML("Tabs are highly customizable using CSS");
		tabPanel.add(moreInfo, "More Info");

		// Make the first tab selected and the tab's content visible
		tabPanel.selectTab(0);

		DockPanel dock = new DockPanel();

		// Allow 4 pixels of spacing between each cell
		dock.setSpacing(4);

		
		// Add text widgets all around
		dock.add(menu, DockPanel.NORTH);
		
		/*
		 * Center each component horizontally within each cell for each component added after this call. A
		 * shortcut to calling dock.setCellHorizontalAlignment() for each cell.
		 */
		dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
		dock.add(new HTML("This is the <i>first</i> south component"), DockPanel.SOUTH);
		dock.add(new HTML("This is the east component"), DockPanel.EAST);
		dock.add(new HTML("This is the west component"), DockPanel.WEST);
		dock.add(tabPanel, DockPanel.NORTH);
		dock.add(new HTML("This is the <i>second</i> south component"), DockPanel.SOUTH);

		// Add scrollable text in the center
		HTML contents = new HTML("This is a <code>ScrollPanel</code> contained at "
				+ "the center of a <code>DockPanel</code>.  " + "By putting some fairly large contents "
				+ "in the middle and setting its size explicitly, it becomes a "
				+ "scrollable area within the page, but without requiring the use of " + "an IFRAME.<br><br>"
				+ "Here's quite a bit more meaningless text that will serve primarily "
				+ "to make this thing scroll off the bottom of its visible area.  "
				+ "Otherwise, you might have to make it really, really small in order "
				+ "to see the nifty scroll bars!");
		ScrollPanel scroller = new ScrollPanel(contents);
		scroller.setSize("400px", "100px");
		dock.add(scroller, DockPanel.CENTER);

		// Add image and button to the RootPanel
		RootPanel.get().add(dock);
	}
}
