package test.level2;

import java.util.*;

public class 광물캐기 {
    /*
     * picks : 곡괭이의 개수, [dia, rion, stone] 순서
     * minerals: 광물들의 순서, 3개의 문자열로 이루어져 있음
     *
     * */

    public static class Mineral {
        private int diamond;
        private int iron;
        private int stone;

        public void setDiamond() {
            this.diamond++;
        }

        public void setIron() {
            this.iron++;
        }

        public void setStone() {
            this.stone++;
        }

        public int getDiamond() {
            return this.diamond;
        }

        public int getIron() {
            return this.iron;
        }

        public int getStone() {
            return this.stone;
        }
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 광물을 5개씩 끊어서 리스트에 저장한다.
        List<Mineral> mineralList = new ArrayList<>();
        Mineral mineral = null;
        for (int i = 0; i < minerals.length; i++) {
            if (i == 0) mineral = new Mineral();

            if (minerals[i].equals("diamond")) mineral.setDiamond();
            if (minerals[i].equals("iron")) mineral.setIron();
            if (minerals[i].equals("stone")) mineral.setStone();

            if (mineral.getDiamond() + mineral.getIron() + mineral.getStone() == 5 || i == minerals.length - 1) {
                mineralList.add(mineral);
                mineral = new Mineral();
            }
        }

        // 곡괭이의 종류별로 광물을 순서대로 5개씩 끊어서 피로도를 계산한다.
        for (Mineral target : mineralList) {
            List<Integer> scoreList = new ArrayList<>();
            int temp = 0;

            if (target.getStone() == 5) {
                temp = 5;

                if(picks[2] > 0) {
                    picks[2]--;
                    continue;
                } else if (picks[1] > 0) {
                    picks[1]--;
                    continue;
                }
            }

                for (int i = 0; i < picks.length; i++) {
                    // 해당 곡괭이가 없으면 Max_value를 부여하고 패스한다.
                    if (picks[i] == 0) {
                        scoreList.add(Integer.MAX_VALUE);
                        continue;
                    }

                    if (picks[i] > 0) {
                        if (i == 0) {
                            temp = target.getDiamond() + target.getIron() + target.getStone();
                        }
                        if (i == 1) {
                            temp = (target.getDiamond() * 5) + ((target.getIron() + target.getStone()) * 1);
                        }
                        if (i == 2) {
                            temp = (target.getDiamond() * 25) + (target.getIron() * 5) + (target.getStone() * 1);
                        }
                    }
                    scoreList.add(temp);
                }

            if (picks[0] <= 0 && picks[1] <= 0 && picks[2] <= 0) break;
            // 가장 낮은 피로도를 정답에 더한다.
            int min = Collections.min(scoreList);
            int index = scoreList.indexOf(min);
            picks[index]--;
            answer += min;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
//        int[] picks = {0, 1, 1};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        System.out.println(solution(picks, minerals));
    }

}
