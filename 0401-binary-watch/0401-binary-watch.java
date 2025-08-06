class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
           List<String> result = new ArrayList<>();

        // Loop over all possible hour and minute values
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Count bits (LEDs on)
                int bitsOn = Integer.bitCount(hour) + Integer.bitCount(minute);
                if (bitsOn == turnedOn) {
                    // Format: hour:minute (minute must be two digits)
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return result;
    }
}