/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
//     public ListNode partition(ListNode head, int x) {
//         ListNode h = head;
//         ListNode lessThanXhead = new ListNode(0);
//         ListNode lessThanX = lessThanXhead; 
//         ListNode cur = head;
//         while(cur!=null){
//             if(cur.val<x){
//                 head = cur.next;
//                 if(lessThanX==null){
//                     lessThanX = cur;
//                     lessThanX = lessThanX.next; 
//                 }else{
//                     lessThanX.next = cur;
//                     lessThanX = lessThanX.next;
//                 }
//             }else{
//                 head = head.next;
//                 cur = cur.next;
//             }
//         }
//         lessThanX.next = head.next;
//         h.next = null;
//         return lessThanXhead.next;
//     }
// }
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0); // lessHead = [0], i.e, lessHead is pointing at 0
        ListNode less = lessHead; //less acts as a pointer to the lessHead linkedlist. So for now its pointer at the element 0. It is exactly same as lessHead. But we will use less to move and keep lessHead pointer stationary. But as less moves and takes values, it will keep adding those same values to lessHead linked list as they are equal   
        ListNode greatHead = new ListNode(0); // greatHead = [0]
        ListNode great = greatHead; //great acts as a pointer to the greatHead ll
        while (head != null) {
            if (head.val < x) {
                less.next = head; //puts the value of next element of less as the value of head and since less is pointing at 0 in lessHead, the next element of lessHead becomes the value of head, i.e, lessHead = [0,1]
                less = less.next; // now the less pointer moves to 1 that is the next element
            } else {
                great.next = head; // sames as less
                great = great.next;
            }
            head = head.next; // moves the head pointer and now it is pointing at 4
            //this is will keep on going untill head becomes null, i.e, when head becomes 2 the last element. After everything is done, the head = head.next moves the head to null which is after 2
        }
        //After iterating through all the linked lists, the pointers are at the end of less, great. 
        //and the linked lists becomes: lessHead =[0, 1, 2, 2] greatHead = [0, 4, 3, 5]
        less.next = greatHead.next; // less.next here moves the pointer to the next position from the last element of less. And that takes whatever greatHead.next has which is 4 because greatHead is still pointing at 0
        great.next = null; //great is pointing at last element that is 5. great.next makes the next element null saying this is the end of this linked list
        //so lessHead = [0, 1, 2, 2, 4, 3, 5]
        return lessHead.next; //lessHead is still pointing at 0 and here we are returning everything after 0 from 1 by using lessHead.next
        //it will return [1, 2, 2, 4, 3, 5]
    }
}
