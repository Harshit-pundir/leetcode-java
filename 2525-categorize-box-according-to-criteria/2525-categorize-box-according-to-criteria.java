class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;
        boolean isHeavy = false;

        if(length >= 10000 || width >= 10000 || height >= 10000 || mass >= 10000 || (long) length * width * height >= 1000000000) isBulky = true;
        if(mass >= 100) isHeavy = true;

        if(isBulky && isHeavy ) return "Both";
        if(!isBulky && !isHeavy) return "Neither";
        if(isBulky && !isHeavy) return "Bulky";
        if(!isBulky && isHeavy) return "Heavy";

        return "";
    }
}