class Solution {
public:
    double angleClock(int hour, int minutes) {
        double angMin = minutes*6;
        double angHour = (hour%12)*30 + minutes*0.5;
        double diff = abs(angMin - angHour);

        return diff < 180 ? diff : 360.0 - diff;
    }
};