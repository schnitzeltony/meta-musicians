SUMMARY = "An old-school drum kit sampler"
HOMEPAGE = "http://drumkv1.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qtbase \
    jack \
    lv2 \
    liblo \
    hydrogen \
"

inherit cmake_qt5 gtk-icon-cache mime

do_convert_crlf_to_lf[depends] += "dos2unix-native:do_populate_sysroot"

# Convert CRLF line terminators to LF for hydrogen2drumkv1 only
do_convert_crlf_to_lf () {
	find ${WORKDIR}/hydrogen2drumkv1 -type f -exec dos2unix {} \;
}

addtask convert_crlf_to_lf after do_unpack before do_patch
SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0002-Avoid-stripping-CMake.patch \
    git://github.com/TuriSc/hydrogen2drumkv1.py.git;name=hydrogen2drumkv1;destsuffix=hydrogen2drumkv1 \
    file://0001-Fix-for-python-3.9.patch;patchdir=../hydrogen2drumkv1 \
"
PV = "0.9.22"
SRC_URI[sha256sum] = "fe67b6ff00bac86faef18f759100e325ce200f508093566f5d30174702a22330"

SRCREV_hydrogen2drumkv1 = "4ca8af8f1433dce33f675ae68e95429c9eed084e"

do_install_append() {
    install -d ${D}${datadir}/${BPN}/presets
    # convert hydrogen drumkits to drumkv1
    export IFS=$'\n'
    for drumkit in `find ${STAGING_DATADIR}/hydrogen/data/drumkits -name drumkit.xml`; do
        echo $drumkit
        drumkit_name=`dirname $drumkit`
        drumkit_name=`basename $drumkit_name`
        echo $drumkit_name
        python3 ${WORKDIR}/hydrogen2drumkv1/hydrogen2drumkv1.py --prefix ${datadir}/hydrogen/data/drumkits/$drumkit_name/ $drumkit ${D}${datadir}/${BPN}/presets/$drumkit_name.drumkv1
    done
}

PACKAGES =+ "${PN}-presets"

FILES_${PN} += " \
    ${datadir}/appdata \
    ${datadir}/mime \
    ${datadir}/metainfo \
    ${datadir}/icons \
    ${libdir}/lv2 \
"

FILES_${PN}-presets += "${datadir}/${BPN}/presets/"
# hydrogen-drumkits contain samples
RDEPENDS_${PN}-presets = "hydrogen-drumkits"
