SUMMARY = "An old-school drum kit sampler"
HOMEPAGE = "http://drumkv1.sourceforge.net/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qtbase \
    jack \
    lv2 \
    liblo \
    hydrogen \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache mime

do_convert_crlf_to_lf[depends] += "dos2unix-native:do_populate_sysroot"

# Convert CRLF line terminators to LF for hydrogen2drumkv1 only
do_convert_crlf_to_lf () {
	find ${WORKDIR}/hydrogen2drumkv1 -type f -exec dos2unix {} \;
}

addtask convert_crlf_to_lf after do_unpack before do_patch
SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://0001-Fix-for-python-3.9.patch;patchdir=../hydrogen2drumkv1 \
    file://0002-Avoid-stripping-CMake.patch \
    git://github.com/TuriSc/hydrogen2drumkv1.py.git;name=hydrogen2drumkv1;destsuffix=hydrogen2drumkv1;branch=master;protocol=https \
"
PV = "0.9.24"
SRC_URI[sha256sum] = "b3d7a4105e94c3b29235d2d00ae74d0be6a00d62e791c968056aa64ff7ac6012"

SRCREV_hydrogen2drumkv1 = "4ca8af8f1433dce33f675ae68e95429c9eed084e"

do_install:append() {
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

FILES:${PN} += " \
    ${datadir}/appdata \
    ${datadir}/mime \
    ${datadir}/metainfo \
    ${datadir}/icons \
    ${libdir}/lv2 \
"

FILES:${PN}-presets += "${datadir}/${BPN}/presets/"
# hydrogen-drumkits contain samples
RDEPENDS:${PN}-presets = "hydrogen-drumkits"
