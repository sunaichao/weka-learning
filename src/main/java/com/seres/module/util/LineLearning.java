package com.seres.module.util;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;
import java.io.IOException;

public class LineLearning {

    public static void main(String[] args) throws Exception {

        /**
         *  分析 https://archive.ics.uci.edu/ml/machine-learning-databases/00242/
         *  Index of /ml/machine-learning-databases/00242
         */
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.setSource(new File("/Users/sunaichao/Documents/Test_Data/ENB2012_data.csv"));
        Instances data = csvLoader.getDataSet();
        data.setClassIndex(data.numAttributes()-2);
        Remove remove = new Remove();
        remove.setOptions(new String[]{"-R",data.numAttributes()+""});
        remove.setInputFormat(data);
        data = Filter.useFilter(data,remove);
        //创建线性函数
        LinearRegression model = new LinearRegression();
        model.buildClassifier(data);

        System.out.println(model.toString());



    }
}
