import java.util.*;

class Solution {
    
    static class Task {
        String name;
        int start;
        int playtime;

        public Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }

    public static String[] solution(String[][] plans) {
        List<String> answerList = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();

        for (String[] plan : plans) {
            tasks.add(new Task(plan[0], change(plan[1]), Integer.parseInt(plan[2])));
        }

        // 시작 시간을 기준으로 오름차순 정렬하기
        tasks.sort((t1, t2) -> t1.start - t2.start);

        // Stack에 멈춤 과제들을 담기
        Stack<Task> stack = new Stack<>();

        for (int i = 0; i < tasks.size() - 1; i++) {
            Task curTask = tasks.get(i);
            Task nextTask = tasks.get(i + 1);

            // 새로운 과제 시작 전에 이용 가능한 시간
            int t = nextTask.start - curTask.start;

            if ( curTask.playtime > t ) { // 과제를 가용 시간에 끝낼 수 없는 경우
                curTask.playtime -= t; // 가용 시간에 작동한 만큼 빼기
                stack.push(curTask);
            } else if ( curTask.playtime == t ) { // 과제를 정확하게 가용 시간에 끝내는 경우
                answerList.add(curTask.name); // 정답 리스트에 과제 이름을 추가하기
            } else { // 과제를 하고도 시간이 남는 경우
                answerList.add(curTask.name); // 정답 리스트에 과제 이름을 추가하기
                t -= curTask.playtime;

                while( !stack.isEmpty() ) {
                    Task stopedTask = stack.peek(); // stack(멈춘 과제 저장)에서 가장 최근에 멈춘 과제 가져오기
                    if ( t >= stopedTask.playtime ) { // 가용 시간에 멈춘 과제를 끝낼 수 있다면
                        t -= stopedTask.playtime; // 가용 시간 최신화
                        answerList.add(stopedTask.name);
                        stack.pop();
                    } else { // 과제를 완전하게 실행할 수 없다면 그냥 일부의 시간을 사용해서 과제를 수행하기
                        stopedTask.playtime -= t;
                        break;
                    }

                }

            }
        }

        // 마지막 과제는 바로 추가
        answerList.add(tasks.get(tasks.size() - 1).name);

        // 스택에 남아있는 멈춘 과제들 다 넣기
        while (!stack.isEmpty()) {
            answerList.add(stack.pop().name);
        }

        return answerList.toArray(new String[0]);
    }

    public static int change(String input) {
        String[] answer = input.split(":");
        int h = Integer.parseInt(answer[0]);
        int m = Integer.parseInt(answer[1]) + h * 60;
        return m;
    }
}