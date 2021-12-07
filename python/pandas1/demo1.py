import pandas as pd
import matplotlib.pyplot as plt
pokedf=pd.read_csv('C:/Users/APPLE/Documents/vs_code/python/pandas1/pokemondata.csv')
# print(pokedf.head())
print(type(pokedf))
print(pokedf.columns)
# print(pokedf.iloc[2:4,2:4])
# print(pokedf.loc[pokedf['Name']=='Pikachu'])
# print(pokedf.describe())
# pokedf.to_csv('modified.csv')
# df2=pd.read_csv('modified.csv')
# print(pokedf.groupby(["Type_1"]).count()['Name'])
x=pokedf['Number'].values
y=pokedf['HP'].values
print(y)
plt.plot(x,y)
plt.show
