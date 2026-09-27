import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Sol {

    final static int MAX_PRODUCTS = 100;

    public static void main(String[] args) {
        int productCount = 0;
        int[] productCodes = new int[MAX_PRODUCTS];
        String[] productNames = new String[MAX_PRODUCTS];
        double[] prices = new double[MAX_PRODUCTS];
        int[] stockQuantities = new int[MAX_PRODUCTS];
        int[] soldQuantities = new int[MAX_PRODUCTS];

        // Scanner for read data from user
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    ===== STORE MANAGEMENT SYSTEM =====
                    1. Add New Product
                    2. Display All Products
                    3. Sell Product
                    4. Restock Product
                    5. Search Product by Code
                    6. Show Low Stock Alert (quantity < 5)
                    7. Calculate Total Inventory Value
                    8. Show Sales Report
                    9. Show Best Selling Product
                    0. Exit
                    ====================================""");

            System.out.println("Enter Your Choice: ");
            int choice = in.nextInt();

            switch(choice) {
                case 1:
                    int check =  addProduct(productCodes, productNames, prices,
                            stockQuantities, soldQuantities, productCount, in);
                    if (check != -1) {
                        productCount = check;
                    }
                    break;

                case 2:
                    displayAllProducts(productCodes, productNames, prices,
                            stockQuantities, soldQuantities, productCount);
                    break;

                case 3:
                    sellProduct(in, productCodes, prices, stockQuantities, soldQuantities, productCount);
                    break;

                case 4:
                    restockProduct(in, productCodes, prices, stockQuantities, productCount);
                    break;

                case 5:
                    searchProductByCode(in, productCodes, productNames, prices, stockQuantities, soldQuantities, productCount);
                    break;

                case 6:
                    lowStockAlert(productCodes, productNames, prices, stockQuantities, soldQuantities, productCount);
                    break;

                case 7:
                    calculateTotalInventoryValue(prices, stockQuantities, productCount);
                    break;

                case 8:
                    salesReport(productCodes, productNames, prices, soldQuantities, productCount);
                    break;

                case 9:
                    bestSellingProduct(productCodes, productNames, prices, soldQuantities, productCount);
                    break;

                case 0:
                    in.close();
                    return;

                default:
                    System.out.println("Undefined Choice!!!!!!, Try Again");
            }


        }


    }

    static int findProductIndex(int[] productCodes, int code, int productCount){
        for(int i = 0; i <= productCount; i++)
            if(productCodes[i] == code) {
                return i;
            }
        // linear search: return the index, or -1 if not found
        return -1;
    }

    static int addProduct(int[] productCodes, String[] productNames, double[] prices,
                     int[] stockQuantities, int[] soldQuantities,
                     int productCount, Scanner scanner){

        // Check if store is full or not
        if(productCount > MAX_PRODUCTS-1) {
            System.out.println("Error: Store is full! Cannot add more products.");
            return -1;
        }

        // Collect data -> validate it
        System.out.println("Enter Your Product Code: ");
        int productCode = scanner.nextInt();

        int index = findProductIndex(productCodes, productCode, productCount);

        for(int prodCode : productCodes) {
            if(index != -1) {
                System.out.println("Error: Product code already exists!");
                return -1;
            }
        }

        scanner.nextLine();

        System.out.println("Enter Your Product Name: ");
        String productName = scanner.nextLine();

        if(productName.isEmpty()) {
            System.out.println("Error: Product name cannot be empty!");
            return -1;
        }


        System.out.println("Enter Your Product Price: ");
        double productPrice = scanner.nextDouble();

        if(productPrice < 0) {
            System.out.println("Error: Price must be greater than 0!");
            return -1;
        }

        System.out.println("Enter Stock Quantity For Your Product: ");
        int productStockQuantity = scanner.nextInt();

        if(productStockQuantity < 0) {
            System.out.println("Error: Stock quantity cannot be negative!");
            return -1;
        }

        // Adding Product Row Data

        productCodes[productCount] = productCode;
        productNames[productCount] = productName;
        prices[productCount] = productPrice;
        stockQuantities[productCount] = productStockQuantity;
        soldQuantities[productCount] = 0;

        productCount++;

        System.out.println("✓ Product added successfully!");

        return productCount;
        // validate, store at productCount, return the (possibly) new count
    }

    static void displayAllProducts(int[] productCodes, String[] productNames,double[] prices,
                              int[] stockQuantities, int[] soldQuantities, int productCount){

        // formatted table
        if(productCount == 0) {
            System.out.println("No products in the system!!");
        }
        else {
            System.out.println("Code\tName\t\t\tPrice\tStock\tSold\t");
            System.out.println("=========================================================================================");
            for(int i = 0; i < productCount; i++) {
                System.out.println(productCodes[i]+"\t\t"+productNames[i]+"\t\t\t\t"+prices[i]+
                        "\t\t"+stockQuantities[i]+"\t\t"+soldQuantities[i]+"\t\t");
            }
            System.out.println("=========================================================================================");
        }
    }

    static void sellProduct(Scanner scanner, int[] productCodes, double[] prices,
                     int[] stockQuantities, int[] soldQuantities, int productCount) {

        System.out.println("Enter Product Code You want to sold it: ");
        int code = scanner.nextInt();

        int index = findProductIndex(productCodes, code, productCount);

        if(index == -1) {
            System.out.println("Error: Product not found!");
            return;
        }

        System.out.println("Enter Quantity You want to sold it: ");
        int orderQuantity = scanner.nextInt();

        if(orderQuantity <= 0) {
            System.out.println("Error: Quantity must be greater than 0!");
            return;
        }

        if(orderQuantity > stockQuantities[index]) {
            System.out.println("Error: Only " + stockQuantities[index] + " units available in stock!");
        }

        double total = prices[index] * orderQuantity;
        stockQuantities[index] -= orderQuantity;
        soldQuantities[index] += orderQuantity;

        System.out.println("✓ Sold " + orderQuantity + " from Product with code " + code + " Successfully");
        System.out.printf("Total Price: $%.2f%n", total);

    }

    static void restockProduct(Scanner scanner, int[] productCodes, double[] prices,
                     int[] stockQuantities, int productCount) {

        System.out.println("Enter Product Code You want to restock it: ");
        int code = scanner.nextInt();

        System.out.println("Enter Quantity You want: ");
        int orderQuantity = scanner.nextInt();

        if(orderQuantity <= 0) {
            System.out.println("Error: Quantity must be greater than 0!");
            return;
        }

        int index = findProductIndex(productCodes, code, productCount);

        if(index == -1) {
            System.out.println("Error: Product not found!");
            return;
        }

        stockQuantities[index] += orderQuantity;

        System.out.println("✓ Product restocked successfully! New stock: " + stockQuantities[index] + " units");

    }


    static void searchProductByCode(Scanner scanner, int[] productCodes, String[] productNames, double[] prices,
                             int[] stockQuantities, int[] soldQuantities, int productCount) {

        System.out.println("Enter Product Code You want to search on it: ");
        int code = scanner.nextInt();

        int index = findProductIndex(productCodes, code, productCount);

        if(index == -1) {
            System.out.println("Error: Product not found!");
            return;
        }

        System.out.println("Code: " + code + ", Name: " + productNames[index] + ", Price: " +
                prices[index] + ", Stock: " + stockQuantities[index] + ", Sold: " + soldQuantities[index] +
                ", Total Revenue: " + (prices[index] * soldQuantities[index]));

    }


    static void lowStockAlert(int[] productCodes, String[] productNames, double[] prices,
                             int[] stockQuantities, int[] soldQuantities, int productCount) {
        int counter = 0;
        System.out.println("Code\tName\t\t\tPrice\tStock\tSold\t");
        System.out.println("=========================================================================================");
        for(int i = 0; i < productCount; i++) {
            if(stockQuantities[i] < 5) {
                System.out.println(productCodes[i]+"\t\t"+productNames[i]+"\t\t\t\t"+prices[i]+
                        "\t\t"+stockQuantities[i]+"\t\t"+soldQuantities[i]+"\t\t");
                counter++;
            }
        }
        System.out.println("=========================================================================================");

        if(counter == 0) {
            System.out.println("✓ All products are well stocked!");
        }
        else {
            System.out.println("Total Low Stock Items: " + counter);
        }
    }

    static void calculateTotalInventoryValue(double[] prices, int[] stockQuantities, int productCount) {
        if(productCount == 0) {
            System.out.println("No products in the system!.");
            return;
        }
        double total = 0;
        for(int i = 0; i < productCount; i++) {
            total += stockQuantities[i] * prices[i];
        }
        System.out.println("Total Inventory Value: " + total);
    }

    static void salesReport(int[] productCodes, String[] productNames, double[] prices,
                     int[] soldQuantities, int productCount) {

        int totalUnitsSold = 0;
        double totalRevenue = 0;
        for(int i = 0; i < productCount; i++) {
            totalUnitsSold += soldQuantities[i];
            totalRevenue += soldQuantities[i] * prices[i];
        }

        if(totalUnitsSold == 0) {
            System.out.println("No sales recorded yet.");
            return;
        }

        System.out.println("■ SALES REPORT ■\n" +
                "================================================================");
        System.out.println("Total Units Sold: " + totalUnitsSold);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Average Sale Value: $"+ (totalRevenue / totalUnitsSold));
        System.out.println();

        totalUnitsSold = 0;
        totalRevenue = 0;
        for(int i = 0; i < productCount; i++) {
            totalUnitsSold += soldQuantities[i];
            totalRevenue += soldQuantities[i] * prices[i];
            System.out.println((i+1) + ". " + productNames[i] + " (Code: " + productCodes[i] + "): " +
                    soldQuantities[i] + " units sold, Revenue: $" + (soldQuantities[i] * prices[i]));
        }
        System.out.println("================================================================");
    }

    static void bestSellingProduct(int[] productCodes, String[] productNames, double[] prices,
                     int[] soldQuantities, int productCount) {

        int totalUnitsSold = 0;
        for(int i = 0; i < productCount; i++) {
            totalUnitsSold += soldQuantities[i];
        }

        if(totalUnitsSold == 0) {
            System.out.println("No sales recorded yet.");
            return;
        }

        int max = soldQuantities[0];
        int maxIndex = 0;
        for(int i = 0; i < productCount; i++) {
            if(max < soldQuantities[i]) {
                maxIndex = i;
            }
        }
         System.out.println((productNames[maxIndex] + " (Code: " + productCodes[maxIndex] + "): " +
                    soldQuantities[maxIndex] + " units sold, Revenue: $" + (soldQuantities[maxIndex] * prices[maxIndex])));
    }


}


