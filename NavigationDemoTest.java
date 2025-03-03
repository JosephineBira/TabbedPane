package Package_NavigationDemo;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
class NavigationDemoTest {

    @Test
    void createDataEntryFrame() {
        JFrame frame1 = new JFrame("Data Entry");
        frame1.setSize(400, 400);
        frame1.setLayout(new BorderLayout());
        frame1.setLocationRelativeTo(null);
        assertInstanceOf(JFrame.class, frame1);
        assertSame("Data Entry", frame1.getTitle());


        JPanel mainPanel = new JPanel();
        assertInstanceOf(JPanel.class, mainPanel);
        assertSame(Color.decode("#87CEEB"), mainPanel.getBackground());


        JPanel formPanelContainer = new JPanel();
        assertInstanceOf(JPanel.class, formPanelContainer);
        assertSame(Color.decode("#87CEEB"), formPanelContainer.getBackground());

        JPanel centerPanel = new JPanel();
        assertInstanceOf(JPanel.class, centerPanel);
        assertNotSame(Color.decode("#87CEEB"), centerPanel.getBackground());


        JPanel buttonPanelContainer = new JPanel();
        assertInstanceOf(JPanel.class, buttonPanelContainer);
        assertNotSame(Color.decode("#87CEEB"), buttonPanelContainer.getBackground());


    }

    @Test
    void createFormPanel() {
        JPanel formPanel = new JPanel();
        String[] expectedLabels = {"Full Name:", "Date of Birth:", "Nationality:", "Sex:", "Country:", "Marital Status:", "Feedback:"};
        String[] actualLabels = new String[expectedLabels.length];

        int index = 0;
        for (Component component : formPanel.getComponents()) {
            if (component instanceof JLabel) {
                actualLabels[index++] = ((JLabel) component).getText();
            }
        }
        assertArrayEquals(expectedLabels, actualLabels);


    }

    @Test
    void testCountry() {
        JPanel formPanel = new JPanel();
        String[] expectedCountries = {"Uganda", "Kenya", "Tanzania", "Rwanda", "Congo", "Burundi"};

        JComboBox<String> CountryComboBox = new JComboBox();

        String[] actualCountries = new String[expectedCountries.length];
        int index = 0;
        for (Component component : formPanel.getComponents()) {
            if (component instanceof JComboBox) {
                actualCountries[index++] = ((JComboBox) component).getName();
            }
            assertArrayEquals(expectedCountries, actualCountries);

        }

    }

    @Test
    void testgender(){
        JPanel formPanel = new JPanel();
        String[] expectedStatus= {"Single", "Married", "Widowed"};

        JComboBox<String> StatusComboBox = new JComboBox();

        String[] actualStatus = new String[expectedStatus.length];
        int index = 0;
        for (Component component : formPanel.getComponents()) {
            if (component instanceof JComboBox) {
                actualStatus[index++] = ((JComboBox) component).getName();
            }
            assertArrayEquals(expectedStatus, actualStatus);

        }
    }

    @Test
    void createButtonPanel(){
        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel fullNameField = new JLabel();
                String fullName = fullNameField.getText();
                JLabel dateOfBirthField= new JLabel();
                String dateOfBirth = dateOfBirthField.getText();
                JLabel nationalityField =new JLabel();
                String nationality = nationalityField.getText();
                JComboBox<Object> genderComboBox = new JComboBox<>();
                String genderSelected = (String) genderComboBox.getSelectedItem();
                JComboBox<Object> countryComboBox = new JComboBox<>();
                String countrySelected = (String) countryComboBox.getSelectedItem();
                JComboBox<Object> statusComboBox = new JComboBox<>();
                String statusSelected = (String) statusComboBox.getSelectedItem();
                JTextArea feedbackTextArea = new JTextArea();
                String feedback = feedbackTextArea.getText();
                String record = "Full Name: " + fullName + "\nDate of Birth: " + dateOfBirth +
                        "\nNationality: " + nationality + "\nSex: " + genderSelected +
                        "\nCountry: " + countrySelected + "\nMarital Status: " + statusSelected +
                        "\nFeedback: " + feedback;
                DefaultListModel<String> listModel= new DefaultListModel<>();
                listModel.addElement(record);
            }

        });

        assertNotNull(submitButton.getActionListeners());
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel fullNameField = new JLabel();
                String fullName = fullNameField.getText();
                JLabel dateOfBirthField= new JLabel();
                String dateOfBirth = dateOfBirthField.getText();
                JLabel nationalityField =new JLabel();
                String nationality = nationalityField.getText();
                JComboBox<Object> genderComboBox = new JComboBox<>();
                String genderSelected = (String) genderComboBox.getSelectedItem();
                JComboBox<Object> countryComboBox = new JComboBox<>();
                String countrySelected = (String) countryComboBox.getSelectedItem();
                JComboBox<Object> statusComboBox = new JComboBox<>();
                String statusSelected = (String) statusComboBox.getSelectedItem();
                JTextArea feedbackTextArea = new JTextArea();
                String feedback = feedbackTextArea.getText();
                String record = "Full Name: " + fullName + "\nDate of Birth: " + dateOfBirth +
                        "\nNationality: " + nationality + "\nSex: " + genderSelected +
                        "\nCountry: " + countrySelected + "\nMarital Status: " + statusSelected +
                        "\nFeedback: " + feedback;
                DefaultListModel<String> listModel= new DefaultListModel<>();
                listModel.addElement(record);
            }
        };
        actionListener.actionPerformed(null);
    }
    @Test
    void testbuttons(){
        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        JButton navigateButton = new JButton("Navigate to Records");

        buttonPanel.add(submitButton);
        buttonPanel.add(navigateButton);
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        assertSame(Color.WHITE, buttonPanel.getBackground());
        assertTrue(buttonPanel.getBorder() instanceof javax.swing.border.LineBorder);
        assertInstanceOf(JButton.class, submitButton);
        assertInstanceOf(JButton.class, navigateButton);

    }
    @Test
    void createRecordsFrame(){
        JFrame frame2 = new JFrame("Records");
        assertDoesNotThrow(() -> {frame2.setVisible(true);}, "Setting the frame visible should not throw an exception even if not fully initialized");
    }




}




