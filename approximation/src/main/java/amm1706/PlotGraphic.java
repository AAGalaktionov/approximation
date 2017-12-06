package amm1706;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlotGraphic {
    public static String plotOne = "ListLinePlot[ { %s }, GridLines -> Automatic, AxesLabel -> {c, T}]"; //, PlotStyle -> (Orange)]");
    public static String plotTwo = "ListLinePlot[ {%s, %s }, GridLines -> Automatic, AxesLabel -> {c, T}]";
    public static String plotThree = "ListLinePlot[ { %s, %s ,%s }, GridLines -> Automatic, AxesLabel -> {c, T}]";
    public static String plotBeams = "ListLinePlot[ { %s }, GridLines -> Automatic, AxesLabel -> {T, Y-c*T}]";

    public static byte[] figure1;
    public static byte[] figure2;


    public static void plot(String exec, boolean beamsPlot) {

        byte[] gifData = KernelConnection.getKernelLink().evaluateToImage(exec, 919, 718);
        if (beamsPlot) {
            figure2 = gifData;
        } else {
            figure1 = gifData;
        }
    }

    protected static String toMathFormat(Map<Double, Double> treeMap) {
        DecimalFormat df = new DecimalFormat("#.###");
        StringBuilder stringBuilder = new StringBuilder("{");
        for (HashMap.Entry<Double, Double> doubleDoubleEntry : treeMap.entrySet()) {
            stringBuilder.append("{" + doubleDoubleEntry.getKey() + "," + df.format(doubleDoubleEntry.getValue().doubleValue()).replace(',', '.') + "},");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected static String toMathFormatBeams(Map<Double, Double> treeMap) {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (HashMap.Entry<Double, Double> doubleDoubleEntry : treeMap.entrySet()) {
            stringBuilder.append("{" + doubleDoubleEntry.getValue() + "," + doubleDoubleEntry.getKey() + "},");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected static String beamsPloatString(Map<Integer, LinkedHashMap<Double, Double>> Beams) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (HashMap.Entry<Integer, LinkedHashMap<Double, Double>> entry : Beams.entrySet()) {
            stringBuilder.append(toMathFormatBeams(entry.getValue())).append(" ,");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

}
