package by.training.shape.service.impl;

import by.training.shape.entity.RightPyramid;
import by.training.shape.service.PyramidService;
import by.training.shape.validator.RightPyramidValidator;


public class RightPyramidServiceImpl implements PyramidService {


    @Override
    public double area(RightPyramid pyramid) {
        double fullArea = 0;
        if (RightPyramidValidator.isRightPyramid(pyramid)){
            double a = baseSideLength(pyramid);
            double b = triangleSideLength(pyramid);
            fullArea = Math.pow(a, 2) + 2 * a * Math.sqrt(Math.pow(b, 2) - Math.pow(a, 2)/4);
        }
        return fullArea;
    }

    @Override
    public double volume(RightPyramid pyramid) {
        double volume = 0;
        if (RightPyramidValidator.isRightPyramid(pyramid)) {
            volume = heightPyramid(pyramid) * Math.pow(baseSideLength(pyramid), 2) / 3;
        }
        return volume;
    }


    public double truncatedArea(double planeCuttingHeight, RightPyramid pyramid) {
        double cutPyramidArea = 0;
        if (RightPyramidValidator.isRightPyramid(pyramid)){
            double k = similarityCoefficientK(planeCuttingHeight, pyramid);
            double cutSideSquare = baseSideLength(pyramid) * k;
            double apofem = Math.sqrt(Math.pow((baseSideLength(pyramid) - cutSideSquare) / 2, 2) + Math.pow(heightPyramid(pyramid) - planeCuttingHeight, 2));
            double perimeterBase = baseSideLength(pyramid) * 4;
            double perimeterCutBase = cutSideSquare * 4;

            double sideSurfaceArea = (perimeterBase + perimeterCutBase) * apofem / 2;
            double baseSquareArea = Math.pow(baseSideLength(pyramid), 2);
            double baseCutSquareArea = Math.pow(cutSideSquare, 2);

            cutPyramidArea = sideSurfaceArea + baseSquareArea + baseCutSquareArea;
        }

        return cutPyramidArea;
    }

    public double truncatedVolume(double planeCuttingHeight, RightPyramid pyramid) {
        double cutPyramidVolume = 0;

        if (RightPyramidValidator.isRightPyramid(pyramid)){
            double k = similarityCoefficientK(planeCuttingHeight, pyramid);
            double cutSideSquare = baseSideLength(pyramid) * k;

            double heightCut = heightPyramid(pyramid) - planeCuttingHeight;
            double baseSquareArea = Math.pow(baseSideLength(pyramid), 2);
            double baseCutSquareArea = Math.pow(cutSideSquare, 2);

            cutPyramidVolume = heightCut / 3 *(baseSquareArea + Math.sqrt(baseSquareArea * baseCutSquareArea) +baseCutSquareArea);
        }

        return cutPyramidVolume;
    }



    public double similarityCoefficientK(double planeCuttingHeight, RightPyramid pyramid){
        double k;
        double height = heightPyramid(pyramid);
        k = planeCuttingHeight / height;
        return k;
    }


    public double baseSideLength(RightPyramid pyramid){
        double result;
        result = Math.sqrt(Math.pow(pyramid.getB().getX() - pyramid.getA().getX(), 2) + Math.pow(pyramid.getB().getY() - pyramid.getA().getY(), 2)
                + Math.pow(pyramid.getB().getY() - pyramid.getA().getY(), 2));
        return result;
    }

    public double triangleSideLength(RightPyramid pyramid){
        double result;
        result = Math.sqrt(Math.pow(pyramid.getHeight().getX() - pyramid.getA().getX(), 2) + Math.pow(pyramid.getHeight().getY() - pyramid.getA().getY(), 2)
                + Math.pow(pyramid.getHeight().getZ() - pyramid.getA().getZ(), 2));
        return result;
    }


    public double heightPyramid(RightPyramid pyramid){
        double result;
        double halfDiag = Math.sqrt(2) * baseSideLength(pyramid) / 2;
        result = Math.sqrt(Math.pow(triangleSideLength(pyramid), 2) - Math.pow(halfDiag, 2));
        return result;
    }


}
