/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 链表的保护节点（提供入口，防止null异常）
        ListNode entry = new ListNode(0, head);//赋值为0，且NEXT = head;
        ListNode last = entry;
        while (head != null) {
            ListNode tail = getGroup(head, k);// 分组
            if (tail == null) break;
            ListNode nextGroupHead = tail.next;//下一组的开头
            reverseList(head, nextGroupHead);// 组内反转，nextGroupHead不需要变，end需要
            //3、当前组跟下一组、上一组的关系, 更新前一组和后一组的边
            last.next = tail;//上一组的next => 1的next是4, 当前组：变成了tail->...->head 1 > 4
            head.next = nextGroupHead;//下一组
            last = head;//1是新last,组从1，2到了3，4，last从之前的空或者头
            head = nextGroupHead;
        }
        return entry.next;
    }

    // 返回k个一组，组的尾部，null表示这组不够k个
    private ListNode getGroup(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) return head; //k步时停止
            head = head.next;
        }
        return null;//还不够k步就空了，说明是最后一组
    }

    // 组的内部反转
    private void reverseList(ListNode head, ListNode stop) {
        //不需要    ListNode last = null了，这一步在3里面做掉了
        ListNode last = head;
        head = head.next;
        while (head != stop) {
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
    }
}
