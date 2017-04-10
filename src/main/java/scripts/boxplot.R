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

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/serviceGamesWonPercentage.jpeg")
boxplot(df$serviceGamesWonPercentage, ylab='Percentage', main='Service games percentage')
dev.off()

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/averageAcesPerMatch.jpeg")
boxplot(df$averageAcesPerMatch, ylab='Percentage', main='Average aces per match')
dev.off()

jpeg("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/averageDoubleFaultsPerMatch.jpeg")
boxplot(df$averageDoubleFaultsPerMatch, ylab='Percentage', main='Average double faults per match')
dev.off()

#summary
setwd("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/")
df = read.csv("servestats.csv")

summary(df$firstServePercentage)
summary(df$firstServePointsWonPercentage)
summary(df$secondServePointsWonPercentage)
summary(df$serviceGamesWonPercentage)
summary(df$averageAcesPerMatch)
summary(df$averageDoubleFaultsPerMatch)

#median cutting
setwd("/Users/aftabhassan/Documents/workspaceneon/TennisDecoded/output/")
df = read.csv("servestats.csv")
factors = c("firstServePercentage","firstServePointsWonPercentage","secondServePointsWonPercentage","serviceGamesWonPercentage","averageAcesPerMatch","averageDoubleFaultsPerMatch")
for(f in factors){
	print(f)
	print(summary(df[,f])["Median"])
	print(summary(df[,f][5:70])["Median"])
	print(summary(df[,f][10:65])["Median"])
	print(summary(df[,f][15:60])["Median"])
	print(summary(df[,f][20:55])["Median"])
	print(summary(df[,f][25:50])["Median"])
	print(summary(df[,f][30:45])["Median"])
	print(summary(df[,f][35:40])["Median"])
	print("done!")
	cat(paste("\n"));
}
