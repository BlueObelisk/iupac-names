@Grab(group='io.github.egonw.bacting', module='managers-cdk', version='1.0.11')
@Grab(group='io.github.egonw.bacting', module='managers-rdf', version='1.0.11')
@Grab(group='io.github.egonw.bacting', module='managers-ui', version='1.0.11')
@Grab(group='io.github.egonw.bacting', module='managers-pubchem', version='1.0.11')
@Grab(group='io.github.egonw.bacting', module='managers-inchi', version='1.0.11')
@Grab(group='io.github.egonw.bacting', module='managers-opsin', version='1.0.11')

import groovy.cli.commons.CliBuilder

workspaceRoot = ".."
ui = new net.bioclipse.managers.UIManager(workspaceRoot);
cdk = new net.bioclipse.managers.CDKManager(workspaceRoot);
bioclipse = new net.bioclipse.managers.BioclipseManager(workspaceRoot);
inchi = new net.bioclipse.managers.InChIManager(workspaceRoot);
rdf = new net.bioclipse.managers.RDFManager(workspaceRoot);
pubchem = new net.bioclipse.managers.PubChemManager(workspaceRoot);
opsin = new net.bioclipse.managers.OpsinManager(workspaceRoot);

filename = "iupac-names.txt"

if (args.length > 0) filename = args[0]

new File("iupac-names.txt").eachLine { name ->
  if (name != "Chemicals_exact") {
    try {
      mol = opsin.parseIUPACName(name)
      inchikey = inchi.generate(mol).key
      println inchikey
    } catch (Exception e) {}
  }
}
