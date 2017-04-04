#[1] "Player"                         "firstServePercentage"          
#[3] "firstServePointsWonPercentage"  "secondServePointsWonPercentage"
#[5] "serviceGamesWonPercentage"      "averageAcesPerMatch"           
#[7] "averageDoubleFaultsPerMatch"   

setwd("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/")
df = read.csv("servestats.csv")

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/firstServePercentage.jpeg")
boxplot(df$firstServePercentage, ylab='Percentage', main='First serve percentage')
dev.off()

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/firstServePointsWonPercentage.jpeg")
boxplot(df$firstServePointsWonPercentage, ylab='Percentage', main='First serve points won percentage')
dev.off()

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/secondServePointsWonPercentage.jpeg")
boxplot(df$secondServePointsWonPercentage, ylab='Percentage', main='Second serve points won percentage')
dev.off()

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/firstServePointsWonPercentage.jpeg")
boxplot(df$firstServePointsWonPercentage, ylab='Percentage', main='First serve points won percentage')
dev.off()

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/serviceGamesWonPercentage.jpeg")
boxplot(df$serviceGamesWonPercentage, ylab='Percentage', main='Service games percentage')
dev.off()

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/averageAcesPerMatch.jpeg")
boxplot(df$averageAcesPerMatch, ylab='Percentage', main='Average aces per match')
dev.off()

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/averageDoubleFaultsPerMatch.jpeg")
boxplot(df$averageDoubleFaultsPerMatch, ylab='Percentage', main='Average double faults per match')
dev.off()
