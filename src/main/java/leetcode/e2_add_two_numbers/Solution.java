package leetcode.e2_add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode hRes = new ListNode(0);

        ListNode cur = hRes;

        ListNode p1 = l1;
        ListNode p2 = l2;

        int carry = 0;

        while (p1 != null || p2 != null) {
            int sum = 0;
            if (p1 != null) {

                System.out.println("p1.val " + p1.val);
                sum += p1.val;
            } else sum += 0;
            if (p2 != null) {
                System.out.println("p2.val " + p2.val);
                sum += p2.val;
            } else sum += 0;
            System.out.println("sum " + sum);

            sum += carry;
            System.out.println("sum " + sum);
            System.out.println("carry " + carry);

            carry = sum / 10;
            System.out.println("carry " + carry);

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return hRes.next;

    }

    public static void main(String[] args) {



    }
}

