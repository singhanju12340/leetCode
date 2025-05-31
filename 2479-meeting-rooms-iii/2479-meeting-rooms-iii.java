class Solution {
    class RoomOccupiedDetail{
        int roomNo;
        int endDuration;
        public RoomOccupiedDetail(int roomNo, int endDuration){
            this.roomNo = roomNo;
            this.endDuration = endDuration;
        }   
    }

    public int mostBooked(int n, int[][] meetings) {
        Queue<Integer> availableRoom = new PriorityQueue<>();
        Queue<RoomOccupiedDetail> occupiedRoom = new PriorityQueue<>(
            (a,b)->{
                if(a.endDuration==b.endDuration){
                    return a.roomNo-b.roomNo;
                }
                return a.endDuration-b.endDuration;
                }
        );
        int[] result = new int[n]; // room count mapping

        Arrays.sort(meetings, (int[] a, int[]b)-> a[0]-b[0]);

        for(int i=0;i<n;i++){
            availableRoom.offer(i); // add room in min heap
        }

        for(int[] meeting: meetings){
            while(!occupiedRoom.isEmpty()){
                // empty rooms whose end time less than current and make those rooms available
                if(occupiedRoom.peek().endDuration<= meeting[0]){
                    int room = occupiedRoom.peek().roomNo;
                    occupiedRoom.poll();
                    availableRoom.offer(room);
                }else{
                    break;
                }
            }

            // check if occupied room causes delay
            if(availableRoom.isEmpty()){
                // assign room with delay
                RoomOccupiedDetail rdetail = occupiedRoom.poll();
                rdetail.endDuration = rdetail.endDuration + (meeting[1]-meeting[0]); // update end duration
                occupiedRoom.offer(rdetail);
                result[rdetail.roomNo]++;
            }else if(!availableRoom.isEmpty()){
                // assign new room
                int newRoom = availableRoom.poll();
                result[newRoom]++;
                 occupiedRoom.offer(new RoomOccupiedDetail(newRoom, meeting[1]));
            }
        }

           int maxRoomNo = -1;
        int maxCount = 0;
        for(int i=0;i<result.length;i++){
            if(maxCount < result[i]){
                maxRoomNo = i;
                maxCount = result[i];
            }
        }
        return maxRoomNo;
          }
}