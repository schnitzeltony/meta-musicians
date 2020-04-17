SUMMARY = "Schema-based YAML parsing and serialisation"
HOMEPAGE = "https://github.com/tlsa/libcyaml"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=52a1707594d3c6694292db3dd1a7f960"

SRC_URI = " \
    git://github.com/tlsa/libcyaml.git;protocol=https \
"
SRCREV = "689766ae2f2a4deb50f888b20160e71e66b4ed92"
PV = "1.0.2"
S = "${WORKDIR}/git"

DEPENDS = "libyaml"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} install
}
