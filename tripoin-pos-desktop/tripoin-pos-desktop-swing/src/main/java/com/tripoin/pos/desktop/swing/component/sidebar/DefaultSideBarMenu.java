package com.tripoin.pos.desktop.swing.component.sidebar;

import com.tripoin.pos.desktop.swing.component.list.*;
import com.tripoin.pos.desktop.swing.dto.MenuHolderDTO;
import com.tripoin.pos.desktop.swing.dto.SectionHolderDTO;
import com.tripoin.pos.desktop.swing.dto.SubSectionHolderDTO;
import com.tripoin.pos.desktop.swing.view.desktoppane.DesktopPaneMain;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/24/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DefaultSideBarMenu extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1355033836513959613L;

    @Autowired
    private DesktopPaneMain desktopPaneMain;

    @Autowired
    private DashboardSubSideBarMenu dashboardSubSideBarMenu;

    @Autowired
    private PosSubSideBarMenu posSubSideBarMenu;

    @Autowired
    private SecuritySubSideBarMenu securitySubSideBarMenu;

    @Autowired
    private CompanySubSideBarMenu companySubSideBarMenu;

    @Autowired
    private FinanceAccountSubSideBarMenu financeAccountSubSideBarMenu;

    @Autowired
    private ProductSubSideBarMenu productSubSideBarMenu;

    @Autowired
    private ProfileSubSideBarMenu profileSubSideBarMenu;

    @Autowired
    private ReportSubSideBarMenu reportSubSideBarMenu;

    @Autowired
    private MenuHolderDTO menuHolderDTO;

    private Toolkit kit = Toolkit.getDefaultToolkit();

    @PostConstruct
    @Override
    public void initComponents() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setContinuousLayout(false);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize((int) (splitPane.getDividerSize() * 1.5));

        Icon iconShoppingCart24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/ShoppingCart/Shopping-cart-24.png")));
        Icon iconDashboard24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Dashboard/Dashboard-24.png")));
        Icon iconMaster24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Database/Database-24.png")));
        Icon iconGlobe24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Protection/Protection-24.png")));
        Icon iconHome16 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Home/home-16.png")));
        Icon iconUser16 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/User/user-16.png")));
        Icon iconWallet16 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Wallet/wallet-16.png")));
        Icon iconBox16 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Box/box-16.png")));

        SideBar sideBar = new SideBar(SideBar.SideBarMode.TOP_LEVEL, false, 300, true);

        SidebarSection sideBarDashboard = new SidebarSection(sideBar, "Dashboard", dashboardSubSideBarMenu, iconDashboard24);
        sideBar.addSection(sideBarDashboard);

        SidebarSection sectionPos = new SidebarSection(sideBar, "Pos", posSubSideBarMenu, iconShoppingCart24);
        sideBar.addSection(sectionPos);

        SideBar innerSideBarMasterData = new SideBar(SideBar.SideBarMode.INNER_LEVEL, false, -1, true);
        innerSideBarMasterData.addSection(new SidebarSection(innerSideBarMasterData, "Company", companySubSideBarMenu, iconHome16));
        innerSideBarMasterData.addSection(new SidebarSection(innerSideBarMasterData, "Finance", financeAccountSubSideBarMenu, iconWallet16));
        innerSideBarMasterData.addSection(new SidebarSection(innerSideBarMasterData, "Product", productSubSideBarMenu, iconBox16));
        innerSideBarMasterData.addSection(new SidebarSection(innerSideBarMasterData, "Profile", profileSubSideBarMenu, iconUser16));

        SidebarSection sectionMasterData = new SidebarSection(sideBar, "Master",  innerSideBarMasterData, iconMaster24);
        sideBar.addSection(sectionMasterData);

        SidebarSection sectionSecurity = new SidebarSection(sideBar, "Security", securitySubSideBarMenu, iconGlobe24);
        sideBar.addSection(sectionSecurity);

        SidebarSection sectionReport = new SidebarSection(sideBar, "Report", reportSubSideBarMenu, iconGlobe24);
        sideBar.addSection(sectionReport);

        splitPane.setLeftComponent(sideBar);
        splitPane.setRightComponent(desktopPaneMain);
        this.setLayout(new BorderLayout());
        this.add(splitPane);
    }

    private List<MenuHolderDTO> generateMenuHolder() {
        List<MenuHolderDTO> menuHolder = new ArrayList<>();

        MenuHolderDTO mapMenuDashboard = new MenuHolderDTO();
        mapMenuDashboard.setMenuName("Dashboard");
        List<SectionHolderDTO> sectionDashboard = new ArrayList<>();
        SectionHolderDTO sectionHolderDashboard = new SectionHolderDTO();
        sectionHolderDashboard.setSectionName("Dashboard");
        sectionDashboard.add(sectionHolderDashboard);
        mapMenuDashboard.setSectionData(sectionDashboard);

        MenuHolderDTO mapMenuPos = new MenuHolderDTO();
        mapMenuPos.setMenuName("Pos");
        List<SectionHolderDTO> sectionPos = new ArrayList<>();
        SectionHolderDTO sectionHolderPos = new SectionHolderDTO();
        sectionHolderDashboard.setSectionName("Pos");
        sectionPos.add(sectionHolderPos);
        mapMenuPos.setSectionData(sectionPos);

        MenuHolderDTO mapMenuMaster = new MenuHolderDTO();
        mapMenuMaster.setMenuName("Master");

        List<SectionHolderDTO> sectionMaster = new ArrayList<>();

        SectionHolderDTO sectionCompany = new SectionHolderDTO();
        sectionCompany.setSectionName("Company");
        List<SubSectionHolderDTO> subSectionCompany = new ArrayList<>();
        SubSectionHolderDTO subSectionHolderDTO = new SubSectionHolderDTO();
        subSectionHolderDTO.setSubSectionName("Company");

        sectionCompany.setSubSectionData(subSectionCompany);

        mapMenuMaster.setSectionData(sectionMaster);



        menuHolder.add(mapMenuDashboard);
        menuHolder.add(mapMenuPos);
        menuHolder.add(mapMenuMaster);
        return menuHolder;
    }
}
