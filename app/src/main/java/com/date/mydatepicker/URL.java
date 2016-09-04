package com.date.mydatepicker;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.StringBuilderPrinter;

/**
 * Created by web6 on 4/29/2016.
 */
public class URL{
    /**
     * Server Configuration Envirionments.
     */
    public enum ServerConfig {
        ServerConfigInt, ServerConfigQA, ServerConfigProd, ServerConfigUAT
    }

    public static ServerConfig CURRENT_BUILD_CONFIG = ServerConfig.ServerConfigInt;

    public static final String getVersionType(Context context) {
        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version = pInfo.versionName;
        if (version.contains("PROD")) {
            return "PROD";
        } else if (version.contains("QA")) {
            return "QA";
        } else if (version.contains("UAT")) {
            return "UAT";
        } else if (version.contains("INT")) {
            return "INT";
        } else {
            throw new RuntimeException("Invalid Version Flavour Found or No Product Flavoud Added to " + "Package.");

        }
    }

    public static String BASE_URL() {

        switch (CURRENT_BUILD_CONFIG) {
            case ServerConfigInt:
                return "http://makeindiacart.com/Service1.svc/";
            case ServerConfigQA:
                return "Add PROD URL";
            case ServerConfigUAT:
                return "Add UAT URL";
            default:
                return "Add PROD URL";
        }
    }

    public static String getSuppliers() {
        return BASE_URL() + "Supplier";
    }

    public static String getSupplierDetailById(String supplierId) {
        return BASE_URL() + "Supplier_Details/" + supplierId;
    }

    public static String getSupplierOutstandingById(String supplierId) {
        return BASE_URL() + "Supplier_OutStanding/" + supplierId;
    }

    public static String getSupplierPurchaseOrderById(String supplierId) {
        return BASE_URL() + "Supplier_PurchaseOrder/" + supplierId;
    }

    public static String getSupplierAnalyticsById(String supplierId) {
        return BASE_URL() + "Supplier_Analytics/" + supplierId;
    }

    public static String getSupplierLedgers(String supplierId) {
        return BASE_URL() + "Supplier_Ledgers/" + supplierId;
    }

    public static String getUpdatelongitude(String supplierId) {
        return BASE_URL() + "Update_longitude/" + supplierId;
    }

    public static String getFastMovingSales(String compid, String Branchid, String Asondate, String summeryId) {
        return null;
        //return ProjectVariables.REPORTS_URL + "FastMovingSales/" + ProjectVariables.CLIENTID + ",1," + compid + "," + Branchid + "," + Asondate + "," + summeryId;
    }

}