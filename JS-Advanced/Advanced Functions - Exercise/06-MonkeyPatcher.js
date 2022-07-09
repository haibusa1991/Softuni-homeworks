function solution(action) {

    switch (action) {
        case 'upvote':
            this.upvotes++;
            break;
        case 'downvote':
            this.downvotes++;
            break;
        case 'score':
            let upvotes = this.upvotes;
            let downvotes = this.downvotes;

            let shouldObfuscate = upvotes + downvotes > 50;
            let obfuscationFactor = Math.ceil(Math.max(upvotes, downvotes) * 0.25);
            let reportedUpvotes = shouldObfuscate ? upvotes + obfuscationFactor : upvotes;
            let reportedDownvotes = shouldObfuscate ? downvotes + obfuscationFactor : downvotes;
            let rating = getRating(upvotes, downvotes);

            return [reportedUpvotes, reportedDownvotes, reportedUpvotes - reportedDownvotes, rating];
    }

    function getRating(upvotes, downvotes) {
        if (downvotes + upvotes < 10) return 'new';
        if (upvotes > (upvotes+downvotes) * 0.66) return 'hot';
        if (upvotes - downvotes >= 0 && upvotes + downvotes > 100) return 'controversial';
        if (upvotes - downvotes < 0) return 'unpopular';

        return 'new';
    }
}