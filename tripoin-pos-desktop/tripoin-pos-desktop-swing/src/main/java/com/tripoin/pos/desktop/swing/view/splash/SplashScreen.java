package com.tripoin.pos.desktop.swing.view.splash;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.dto.param.SplashScreenParam;
import com.tripoin.pos.desktop.swing.view.frame.MainFrame;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.List;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class SplashScreen implements IParameterizedComponent<SplashScreenParam> {
    
    @Autowired
    protected MainFrame frame;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${splashscreen.loading.time}")
    private Integer splashScreenLoadingTime;

    private JDialog dialog; 
    
    private JProgressBar progress;

    private SplashScreenParam splashScreenParam;

    protected void initUI() throws MalformedURLException {
        showSplashScreen();
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(splashScreenLoadingTime);
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                progress.setValue(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
                showFrame();
                hideSplashScreen();
            }
        };
        worker.execute();
    }

    protected void hideSplashScreen() {
        dialog.setVisible(false);
        dialog.dispose();
    }

    protected void showSplashScreen() throws MalformedURLException {
        dialog = new JDialog((Frame) null);
        dialog.setModal(false);
        dialog.setUndecorated(true);        
        JLabel background = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(splashScreenParam.getSplashScreenImageUrl())));
        background.setLayout(new BorderLayout());
        dialog.add(background);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image splashScreenIcon = kit.getImage(getClass().getClassLoader().getResource(splashScreenParam.getIconImageUrl()));
        dialog.setIconImage(splashScreenIcon);
        JLabel lblLoading = new JLabel(rb.getValue("splash.loading"));
        lblLoading.setForeground(Color.WHITE);
        lblLoading.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));
        background.add(lblLoading);
        progress = new JProgressBar();
        background.add(progress, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void showFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setVisible(true);
    }

    public void startSplash() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e){
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        SwingUtilities.invokeLater(() -> {
            try {
                initUI();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setParam(SplashScreenParam p_Param) {
        this.splashScreenParam = p_Param;
    }

    @Override
    public SplashScreenParam getParam() {
        return splashScreenParam;
    }
}
