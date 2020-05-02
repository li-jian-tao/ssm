package com.briup.util;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;

public class columnarTools {

	public static JFreeChart createCoColumnar(CategoryDataset dataset) {
	    // 创建柱状图
	    JFreeChart chart = ChartFactory.createBarChart3D("当前用户浏览资讯统计", // 图表标题
	            "资讯栏目", // x轴的显示标签
	            "浏览次数", // y轴的显示标签
	            dataset, // 数据
	            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
	            true, // 显示图例
	            true, // 生成工具
	            true // URL链接
	            );
	    // 对整个图形设置整个柱状图的颜色和文字针
	    chart.setBackgroundPaint(ChartColor.WHITE); // 设置总的背景颜色
	    // 获得图形对象，并通过此对象对图形的颜色文字进行设置
	    CategoryPlot polt = chart.getCategoryPlot();// 获得图表对象
	    polt.setBackgroundPaint(ChartColor.lightGray);// 图形背景颜色
	    polt.setRangeGridlinePaint(ChartColor.WHITE);// 图形表格颜色
	    // 设置柱宽度
	    BarRenderer renderer = (BarRenderer) polt.getRenderer();
	    renderer.setMaximumBarWidth(0.06);
	    renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	    renderer.setBaseItemLabelsVisible(true);
	    renderer.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
	    // 设置文字
	    getChartByFont(chart);
	    return chart;
	}

	private static void getChartByFont(JFreeChart chart) {
	    // 图形设置标题文字
	    TextTitle textTitle = chart.getTitle();
	    textTitle.setFont(new Font("宋体", Font.BOLD, 20));

	    // 设置图形X轴坐标文字
	    CategoryPlot plot = (CategoryPlot) chart.getPlot();
	    CategoryAxis axis = plot.getDomainAxis();
	    axis.setLabelFont(new Font("宋体", Font.BOLD, 22)); // 设置X轴坐标上标题的文字
	    axis.setTickLabelFont(new Font("宋体", Font.BOLD, 15)); // 设置X轴坐标上的文字

	    // 设置图形Y轴坐标文字
	    ValueAxis valueAxis = plot.getRangeAxis();
	    valueAxis.setLabelFont(new Font("宋体", Font.BOLD, 12)); // 设置Y轴坐标上标题的文字
	    valueAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));// 设置Y轴坐标上的文字
	    // 设置提示内容的文字
	    chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
	}
	
	public static void saveAsFile(JFreeChart chart, String outputPath,
            int weight, int height) {      
        FileOutputStream out = null;      
        try {
            File outFile = new File(outputPath);      
            if (!outFile.getParentFile().exists()) {      
                outFile.getParentFile().mkdirs();      
            }      
            out = new FileOutputStream(outputPath);      
            // 保存为PNG      
            ChartUtilities.writeChartAsPNG(out, chart, weight, height);      
            // 保存为JPEG      
            // ChartUtilities.writeChartAsJPEG(out, chart, weight, height);      
            out.flush();      
        } catch (FileNotFoundException e) {      
            e.printStackTrace();      
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
            if (out != null) {      
                try {      
                    out.close();      
                } catch (IOException e) {      
                    // do nothing      
                }      
            }      
        }      
    }      
}
