package main.java;

/**
 * @author sakura
 * @date: 2021/3/14 15:15
 * @description:
 */
public class Leecode53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        State state = new State();
        doSubArray(nums, state, 0, nums.length - 1);
        return state.max;
    }

    private void doSubArray(int[] nums, State state, int l, int r) {

    }

    public class State {
        int l = 0;
        int r = 0;
        int max = 0;

        public State() {
        }

        public State(State state) {
            this.l = state.l;
            this.r = state.r;
            this.max = state.max;
        }

        public void setState(State state) {
            this.l = state.l;
            this.r = state.r;
            this.max = state.max;
        }
    }
}
