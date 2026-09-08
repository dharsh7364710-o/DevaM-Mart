import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class DevaMMart extends JFrame {
    Color blue = new Color(135, 206, 250);
    Color darkBlue = new Color(30, 100, 180);
    Color lightBlue = new Color(220, 240, 255);
    Color iceCream = new Color(90, 90, 90);
    String registeredName = "";
    String registeredEmail = "";
    String registeredPassword = "";
    String registeredDOB = "";
    ArrayList<String> cartItems = new ArrayList<>();
    ArrayList<Double> cartPrices = new ArrayList<>();
    String[] products = {
        "Vanilla Ice Cream",
        "Chocolate Ice Cream",
        "Strawberry Ice Cream",
        "Butterscotch Ice Cream",
        "Mango Ice Cream",
        "Pista Ice Cream",
        "Black Currant Ice Cream",
        "Cookies & Cream"
    };
    double[] prices = {
        50, 40, 30, 35, 20, 15, 60, 20
    };
    JPanel mainPanel;
    DevaMMart() {
        setTitle("DevaM Mart");
        setSize(750, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showLoginPage();
        setVisible(true);
    }
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setBackground(darkBlue);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBorder(
            BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );
        JLabel title = new JLabel("🍦 WELCOME TO DEVAM MART 🍦");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
       JLabel subtitle = new JLabel(
    "Chill, Scoop & Enjoy! 🍦💙"
);
        subtitle.setForeground(Color.WHITE);
        subtitle.setFont(
            new Font("Arial", Font.ITALIC, 16)
        );
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(subtitle);
        return header;
    }
    JButton createButton(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("Arial", Font.BOLD, 14));
        b.setBackground(darkBlue);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);

        return b;
    }
    // ================= LOGIN PAGE =================
    void showLoginPage() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(blue);
        mainPanel.add(
            createHeader(),
            BorderLayout.NORTH
        );
        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(lightBlue);
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(8, 8, 8, 8);
        g.fill = GridBagConstraints.HORIZONTAL;
        JLabel title = new JLabel(
            "🔐 LOGIN TO YOUR ACCOUNT"
        );
        title.setFont(
            new Font("Arial", Font.BOLD, 22)
        );
        title.setForeground(iceCream);
        JTextField email = new JTextField(20);
        JPasswordField password =
            new JPasswordField(20);
        JButton signIn =
            createButton("SIGN IN");
        JButton registration =
            createButton("REGISTRATION");
        JButton forgot =
            createButton("FORGOT PASSWORD");
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;
        center.add(title, g);
        g.gridwidth = 1;
        g.gridy++;
        g.gridx = 0;
        center.add(
            new JLabel("Email ID:"),
            g
        );
        g.gridx = 1;
        center.add(email, g);
        g.gridy++;
        g.gridx = 0;
        center.add(
            new JLabel("Password:"),
            g
        );
        g.gridx = 1;
        center.add(password, g);
        g.gridy++;
        g.gridx = 0;
        center.add(signIn, g);
        g.gridx = 1;
        center.add(registration, g);
        g.gridy++;
        g.gridx = 0;
        g.gridwidth = 2;
        center.add(forgot, g);
        mainPanel.add(
            center,
            BorderLayout.CENTER
        );
        setContentPane(mainPanel);
        revalidate();
        repaint();
        // LOGIN VALIDATION
        signIn.addActionListener(e -> {
            String em =
                email.getText().trim();
            String pw =
                new String(
                    password.getPassword()
                );
            if (registeredEmail.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please register first! 💙"
                );
            } else if (
                em.equals(registeredEmail)
                &&
                pw.equals(registeredPassword)
            ) {
                JOptionPane.showMessageDialog(
                    this,
                    "Login Successful! 🎉🍦"
                );
                showShopPage();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Invalid Email or Password!",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
        registration.addActionListener(
            e -> showRegistrationPage()
        );
        forgot.addActionListener(
            e -> showForgotPassword()
        );
    }
    // ================= REGISTRATION PAGE =================
    void showRegistrationPage() {
        mainPanel =
            new JPanel(new BorderLayout());
        mainPanel.setBackground(blue);
        mainPanel.add(
            createHeader(),
            BorderLayout.NORTH
        );
        JPanel form =
            new JPanel(new GridBagLayout());
        form.setBackground(lightBlue);
        GridBagConstraints g =
            new GridBagConstraints();
        g.insets =
            new Insets(7, 7, 7, 7);
        g.fill =
            GridBagConstraints.HORIZONTAL;
        JLabel title =
            new JLabel(
                "📝 CREATE NEW ACCOUNT"
            );
        title.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                22
            )
        );
        title.setForeground(iceCream);
        JTextField name =
            new JTextField(20);
        JTextField email =
            new JTextField(20);
        JPasswordField password =
            new JPasswordField(20);
        JTextField dob =
            new JTextField(20);
        JButton register =
            createButton("REGISTER");
        JButton back =
            createButton("BACK TO LOGIN");
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;
        form.add(title, g);
        g.gridwidth = 1;
        g.gridy++;
        g.gridx = 0;
        form.add(
            new JLabel("Name:"),
            g
        );
        g.gridx = 1;
        form.add(name, g);
        g.gridy++;
        g.gridx = 0;
        form.add(
            new JLabel("Email ID:"),
            g
        );
        g.gridx = 1;
        form.add(email, g);
        g.gridy++;
        g.gridx = 0;
        form.add(
            new JLabel("Password:"),
            g
        );
        g.gridx = 1;
        form.add(password, g);
        g.gridy++;
        g.gridx = 0;
        form.add(
            new JLabel("Date of Birth:"),
            g
        );
        g.gridx = 1;
        form.add(dob, g);
        g.gridy++;
        g.gridx = 0;
        form.add(register, g);
        g.gridx = 1;
        form.add(back, g);
        mainPanel.add(
            form,
            BorderLayout.CENTER
        );
        setContentPane(mainPanel);
        revalidate();
        repaint();
        // REGISTRATION VALIDATION
        register.addActionListener(e -> {
            String n =
                name.getText().trim();
            String em =
                email.getText().trim();

            String pw =
                new String(
                    password.getPassword()
                );

            String d =
                dob.getText().trim();

            if (
                n.isEmpty()
                ||
                em.isEmpty()
                ||
                pw.isEmpty()
                ||
                d.isEmpty()
            ) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please fill all the details! ⚠️"
                );

                return;
            }

            if (
                !em.contains("@")
                ||
                !em.contains(".")
            ) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid Email ID! ⚠️"
                );

                return;
            }

            registeredName = n;
            registeredEmail = em;
            registeredPassword = pw;
            registeredDOB = d;

            JOptionPane.showMessageDialog(
                this,
                "Registration Successful! 🎉🍦\n"
                +
                "Welcome "
                +
                registeredName
                +
                "!"
            );

            showLoginPage();
        });

        back.addActionListener(
            e -> showLoginPage()
        );
    }

    // ================= FORGOT PASSWORD =================

    void showForgotPassword() {

        if (registeredEmail.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "No registered account found! "
                +
                "Please register first."
            );

            return;
        }

        String email =
            JOptionPane.showInputDialog(
                this,
                "Enter your registered Email ID:"
            );

        if (email == null)
            return;

        if (
            email.trim().equals(
                registeredEmail
            )
        ) {

            JOptionPane.showMessageDialog(
                this,
                "Password recovery successful! 🔐\n"
                +
                "Your password is: "
                +
                registeredPassword
            );

        } else {

            JOptionPane.showMessageDialog(
                this,
                "Email ID not found! ❌",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // ================= SHOP PAGE =================

    void showShopPage() {

        mainPanel =
            new JPanel(new BorderLayout());

        mainPanel.setBackground(blue);

        JPanel header =
            createHeader();

        JPanel top =
            new JPanel(new BorderLayout());

        top.setBackground(darkBlue);

        JLabel welcome =
            new JLabel(
                "Hi "
                +
                registeredName
                +
                "! Choose Your Favourite Ice Cream 💙"
            );

        welcome.setForeground(Color.WHITE);

        welcome.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                15
            )
        );

        JTextField search =
            new JTextField();

        search.setPreferredSize(
            new Dimension(170, 32)
        );

        JButton searchButton =
            createButton("🔍 SEARCH");

        JButton cartButton =
            createButton("🛒 VIEW CART");

        JPanel searchPanel =
            new JPanel();

        searchPanel.setBackground(
            darkBlue
        );

        searchPanel.add(search);
        searchPanel.add(searchButton);
        searchPanel.add(cartButton);

        top.add(
            welcome,
            BorderLayout.WEST
        );

        top.add(
            searchPanel,
            BorderLayout.EAST
        );

        JPanel north =
            new JPanel(new BorderLayout());

        north.add(
            header,
            BorderLayout.NORTH
        );

        north.add(
            top,
            BorderLayout.SOUTH
        );

        mainPanel.add(
            north,
            BorderLayout.NORTH
        );

        JPanel productPanel =
            new JPanel(
                new GridLayout(
                    0,
                    2,
                    12,
                    12
                )
            );

        productPanel.setBackground(
            lightBlue
        );

        productPanel.setBorder(
            BorderFactory.createEmptyBorder(
                15,
                15,
                15,
                15
            )
        );

        for (
            int i = 0;
            i < products.length;
            i++
        ) {

            addProductCard(
                productPanel,
                i
            );
        }

        JScrollPane scroll =
            new JScrollPane(productPanel);

        mainPanel.add(
            scroll,
            BorderLayout.CENTER
        );

        setContentPane(mainPanel);

        revalidate();
        repaint();

        // SEARCH

        searchButton.addActionListener(e -> {

            String text =
                search.getText()
                .trim()
                .toLowerCase();

            productPanel.removeAll();

            if (text.isEmpty()) {

                for (
                    int i = 0;
                    i < products.length;
                    i++
                ) {

                    addProductCard(
                        productPanel,
                        i
                    );
                }

            } else {

                boolean found = false;

                for (
                    int i = 0;
                    i < products.length;
                    i++
                ) {

                    if (
                        products[i]
                        .toLowerCase()
                        .contains(text)
                    ) {

                        addProductCard(
                            productPanel,
                            i
                        );

                        found = true;
                    }
                }

                if (!found) {

                    JLabel no =
                        new JLabel(
                            "No Ice Cream Found 😢"
                        );

                    no.setFont(
                        new Font(
                            "Arial",
                            Font.BOLD,
                            22
                        )
                    );

                    no.setForeground(
                        darkBlue
                    );

                    productPanel.add(no);
                }
            }

            productPanel.revalidate();
            productPanel.repaint();
        });

        cartButton.addActionListener(
            e -> showCart()
        );
    }

    // ================= PRODUCT CARD =================

    void addProductCard(
        JPanel panel,
        int index
    ) {

        JPanel card = new JPanel();

        card.setBackground(Color.WHITE);

        card.setBorder(
            BorderFactory.createLineBorder(
                darkBlue,
                2
            )
        );

        card.setLayout(
            new BoxLayout(
                card,
                BoxLayout.Y_AXIS
            )
        );

        JLabel emoji =
            new JLabel("🍦");

        emoji.setFont(
            new Font(
                "Segoe UI Emoji",
                Font.PLAIN,
                40
            )
        );

        emoji.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        JLabel name =
            new JLabel(
                products[index]
            );

        name.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                18
            )
        );

        name.setForeground(
            iceCream
        );

        name.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        JLabel price =
            new JLabel(
                "₹ "
                +
                prices[index]
            );

        price.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                16
            )
        );

        price.setForeground(
            darkBlue
        );

        price.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        JButton add =
            createButton(
                "ADD TO CART 🛒"
            );

        JButton buy =
            createButton(
                "BUY NOW 💳"
            );

        add.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        buy.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        card.add(
            Box.createVerticalStrut(8)
        );
        card.add(emoji);
        card.add(name);
        card.add(price);
        card.add(
            Box.createVerticalStrut(5)
        );
        card.add(add);
        card.add(
            Box.createVerticalStrut(5)
        );
        card.add(buy);
        card.add(
            Box.createVerticalStrut(8)
        );
        panel.add(card);
        // ADD TO CART
        add.addActionListener(e -> {
            cartItems.add(
                products[index]
            );
            cartPrices.add(
                prices[index]
            );
            JOptionPane.showMessageDialog(
                this,
                products[index]
                +
                " added to cart! 🛒🍦"
            );
        });

        // BUY NOW

        buy.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                this,

                "🎉 ORDER PLACED SUCCESSFULLY! 🎉\n\n"
                +
                "Product: "
                +
                products[index]
                +
                "\n"
                +
                "Price: ₹"
                +
                prices[index]
                +
                "\n\n"
                +
                "Thank you for shopping at DevaM Mart! 🍦💙",

                "Order Successful",

                JOptionPane.INFORMATION_MESSAGE
            );
        });
    }

    // ================= CALCULATE TOTAL =================

    double calculateTotal() {

        double total = 0;

        for (
            int i = 0;
            i < cartPrices.size();
            i++
        ) {

            total += cartPrices.get(i);
        }

        return total;
    }

    // ================= CART PAGE =================

    void showCart() {

        mainPanel =
            new JPanel(new BorderLayout());

        mainPanel.setBackground(blue);

        mainPanel.add(
            createHeader(),
            BorderLayout.NORTH
        );

        JPanel cart = new JPanel();

        cart.setBackground(
            lightBlue
        );

        cart.setLayout(
            new BoxLayout(
                cart,
                BoxLayout.Y_AXIS
            )
        );

        cart.setBorder(
            BorderFactory.createEmptyBorder(
                20,
                20,
                20,
                20
            )
        );

        JLabel title =
            new JLabel(
                "🛒 YOUR ICE CREAM CART"
            );

        title.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                24
            )
        );

        title.setForeground(
            iceCream
        );

        title.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        cart.add(title);

        cart.add(
            Box.createVerticalStrut(20)
        );

        if (cartItems.isEmpty()) {

            JLabel empty =
                new JLabel(
                    "Your Cart is Empty 🛒"
                );

            empty.setFont(
                new Font(
                    "Arial",
                    Font.BOLD,
                    20
                )
            );

            empty.setForeground(
                darkBlue
            );

            empty.setAlignmentX(
                Component.CENTER_ALIGNMENT
            );

            cart.add(empty);

        } else {

            for (
                int i = 0;
                i < cartItems.size();
                i++
            ) {

                JLabel item =
                    new JLabel(
                        "🍦 "
                        +
                        cartItems.get(i)
                        +
                        "     ₹"
                        +
                        cartPrices.get(i)
                    );
                item.setFont(
                    new Font(
                        "Arial",
                        Font.BOLD,
                        18
                    )
                );
                item.setAlignmentX(
                    Component.CENTER_ALIGNMENT
                );
                cart.add(item);
                cart.add(
                    Box.createVerticalStrut(8)
                );
            }
        }
        final double total =
            calculateTotal();
        JLabel totalLabel =
            new JLabel(
                "TOTAL: ₹"
                +
                total
            );
        totalLabel.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                22
            )
        );
        totalLabel.setForeground(
            darkBlue
        );
        totalLabel.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );
        cart.add(
            Box.createVerticalStrut(20)
        );
        cart.add(totalLabel);
        JButton buy =
            createButton(
                "BUY ALL 💳"
            );
        JButton clear =
            createButton(
                "CLEAR CART 🗑"
            );
        JButton back =
            createButton(
                "CONTINUE SHOPPING 🍦"
            );
        buy.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );
        clear.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );
        back.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );
        cart.add(
            Box.createVerticalStrut(15)
        );
        cart.add(buy);
        cart.add(
            Box.createVerticalStrut(8)
        );
        cart.add(clear);
        cart.add(
            Box.createVerticalStrut(8)
        );
        cart.add(back);
        mainPanel.add(
            new JScrollPane(cart),
            BorderLayout.CENTER
        );
        setContentPane(mainPanel);
        revalidate();
        repaint();
        // BUY ALL
        buy.addActionListener(e -> {
            if (cartItems.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Your cart is empty! 🛒"
                );
            } else {
                JOptionPane.showMessageDialog(
                    this,

                    "🎉 ORDER PLACED SUCCESSFULLY! 🎉\n\n"
                    +
                    "Total Amount: ₹"
                    +
                    total
                    +
                    "\n\n"
                    +
                    "Thank you for shopping with DevaM Mart! 🍦💙",
                    "Order Successful",
                    JOptionPane.INFORMATION_MESSAGE
                );
                cartItems.clear();
                cartPrices.clear();
                showShopPage();
            }
        });
        // CLEAR CART
        clear.addActionListener(e -> {
            cartItems.clear();
            cartPrices.clear();
            showCart();
        });
        // BACK
        back.addActionListener(
            e -> showShopPage()
        );
    }
    // ================= MAIN =================
    public static void main(String[] args) {

        SwingUtilities.invokeLater(
            () -> new DevaMMart()
        );
    }
}