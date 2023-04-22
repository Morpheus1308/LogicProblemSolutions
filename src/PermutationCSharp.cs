public class Solution {
    public IList<IList<int>> variations;
    public IList<IList<int>> Permute(int[] nums) {

        IList<IList<int>> res = new List<IList<int>>();
        dfs(0, new List<int>(), new bool[nums.Length], res, nums);
        return res;
    }

    public void dfs(int startIndex, IList<int> path, bool[] used, IList<IList<int>> res, int[] nums){
        if(startIndex == used.Length){
            Console.WriteLine(string.Join(", ", path));
            IList<int> newList = new List<int>(path);
            res.Add(newList);
            return;
        }
        for(var i = 0; i < used.Length; i++){
            if(used[i]){
                continue;
            }
            path.Add(nums[i]);
            used[i] = true;
            dfs(startIndex+1, path, used, res, nums);
            path.RemoveAt(path.Count - 1);
            used[i] = false;
        }
    }
}
